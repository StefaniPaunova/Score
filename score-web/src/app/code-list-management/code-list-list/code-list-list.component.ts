import {Component, Inject, OnInit, ViewChild} from '@angular/core';
import {
  MAT_DIALOG_DATA,
  MatDialog,
  MatDialogConfig,
  MatPaginator,
  MatSnackBar,
  MatSort,
  MatTableDataSource,
  PageEvent
} from '@angular/material';
import {SelectionModel} from '@angular/cdk/collections';
import {CodeListForList, CodeListForListRequest} from '../domain/code-list';
import {CodeListService} from '../domain/code-list.service';
import {MatDatepickerInputEvent} from '@angular/material/typings/datepicker';
import {AccountListService} from '../../account-management/domain/account-list.service';
import {PageRequest} from '../../basis/basis';

@Component({
  selector: 'srt-code-list-list',
  templateUrl: './code-list-list.component.html',
  styleUrls: ['./code-list-list.component.css']
})
export class CodeListListComponent implements OnInit {

  title = 'Code Lists';

  displayedColumns: string[] = [
    'select', 'codeListName', 'basedCodeListName', 'agencyId',
    'versionId', 'extensible', 'lastUpdateTimestamp'
  ];
  dataSource = new MatTableDataSource<CodeListForList>();
  selection = new SelectionModel<CodeListForList>(true, []);
  loading = false;

  loginIdList: string[] = [];
  request: CodeListForListRequest;

  @ViewChild(MatSort, {static: true}) sort: MatSort;
  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;

  constructor(private service: CodeListService,
              private accountService: AccountListService,
              private dialog: MatDialog,
              private snackBar: MatSnackBar) {
  }

  ngOnInit() {
    this.request = new CodeListForListRequest();

    this.paginator.pageIndex = 0;
    this.paginator.pageSize = 10;
    this.paginator.length = 0;

    this.sort.active = 'lastUpdateTimestamp';
    this.sort.direction = 'desc';
    this.sort.sortChange.subscribe(() => {
      this.paginator.pageIndex = 0;
      this.onChange();
    });

    this.accountService.getAccountNames().subscribe(loginIds => this.loginIdList.push(...loginIds));
    this.onChange();
  }

  onPageChange(event: PageEvent) {
    this.onChange();
  }

  onChange() {
    this.loadCodeList();
  }

  onDateEvent(type: string, event: MatDatepickerInputEvent<Date>) {
    switch (type) {
      case 'startDate':
        this.request.updatedDate.start = new Date(event.value);
        break;
      case 'endDate':
        this.request.updatedDate.end = new Date(event.value);
        break;
    }
  }

  reset(type: string) {
    switch (type) {
      case 'startDate':
        this.request.updatedDate.start = null;
        break;
      case 'endDate':
        this.request.updatedDate.end = null;
        break;
    }
  }

  loadCodeList() {
    this.loading = true;

    this.request.page = new PageRequest(
      this.sort.active, this.sort.direction,
      this.paginator.pageIndex, this.paginator.pageSize);

    this.service.getCodeListList(this.request)
      .subscribe(resp => {
        this.paginator.length = resp.length;
        this.dataSource.data = resp.list.map((elm: CodeListForList) => {
          elm.lastUpdateTimestamp = new Date(elm.lastUpdateTimestamp);
          return elm;
        });
        this.loading = false;
      });
  }

  /** Whether the number of selected elements matches the total number of rows. */
  isAllSelected() {
    const numSelected = this.selection.selected.length;
    const numRows = this.dataSource.data.filter(row => row.state === 'Editing').length;
    return numSelected === numRows;
  }

  /** Selects all rows if they are not all selected; otherwise clear selection. */
  masterToggle() {
    this.isAllSelected() ?
      this.selection.clear() :
      this.dataSource.data.forEach(row => this.select(row));
  }

  select(row) {
    if (row.state === 'Editing') {
      this.selection.select(row);
    }
  }

  toggle(row) {
    if (this.selection.isSelected(row)) {
      this.selection.deselect(row);
    } else {
      this.select(row);
    }
  }

  discard() {
    this.openDialogCodeListListDiscard();
  }

  openDialogCodeListListDiscard() {
    const dialogConfig = new MatDialogConfig();
    const codeListIds = [];
    for (const elm of this.selection.selected) {
      codeListIds.push(elm.codeListId);
    }
    dialogConfig.data = {ids: codeListIds};

    const dialogRef = this.dialog.open(DialogDiscardCodeListDialogComponent, dialogConfig);
    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.service.delete(...codeListIds).subscribe(_ => {
          this.snackBar.open('Discarded', '', {
            duration: 1000,
          });
          this.selection.clear();
          this.loadCodeList();
        });
      }
    });
  }

}

@Component({
  selector: 'srt-dialog-discard-code-list-dialog',
  templateUrl: 'dialog-discard-code-list-dialog.html',
})
export class DialogDiscardCodeListDialogComponent {

  constructor(@Inject(MAT_DIALOG_DATA) public data: any) {
  }

}

