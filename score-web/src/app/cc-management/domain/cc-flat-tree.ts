import {BbieScFlatNode, BieFlatNode, ChangeListener} from '../../bie-management/domain/bie-flat-tree';
import {
  FlatNode,
  FlatNodeFlattener,
  FlatNodeFlattenerListener,
  getKey,
  next,
  VSFlatTreeControl,
  VSFlatTreeDataSource
} from '../../common/flat-tree';
import {
  CcAccNodeDetail,
  CcAsccpNodeDetail,
  CcBccpNodeDetail, CcDtNodeDetail,
  CcBdtScNodeDetail,
  CcGraph,
  CcGraphNode,
  CcNodeDetail
} from './core-component-node';
import {CcNodeService} from './core-component-node.service';

export interface CcFlatNode extends FlatNode {
  type: string;
  releaseId: number;
  guid: string;
  state: string;
  deprecated: boolean;
  access: string;
  manifestId: number;
  revisionNum: number;

  isCycle: boolean;
  isChanged: boolean;
  detail: CcNodeDetail;
  parents: CcFlatNode[];

  inhibited: boolean;

  typeClass: string;

  addChangeListener(listener: ChangeListener<CcFlatNode>);
  fireChangeEvent(propertyName: string, val: any);
  reset();
}

export abstract class CcFlatNodeImpl implements CcFlatNode {
  level: number;
  _expanded: boolean;
  expandable: boolean;

  parent?: FlatNode;
  children: FlatNode[] = [];

  changeListeners: ChangeListener<CcFlatNode>[] = [];

  state: string;
  access: string;
  revisionNum: number;
  isCycle: boolean = false;

  detail: CcNodeDetail;

  abstract get guid(): string;
  abstract get name(): string;
  abstract get type(): string;
  abstract get typeClass(): string;
  abstract get manifestId(): number;
  abstract get releaseId(): number;

  get expanded(): boolean {
    return this._expanded || false;
  }

  set expanded(expanded: boolean) {
    this._expanded = expanded;
  }

  get hasExtension(): boolean {
    return this._hasExtension(this);
  }

  _hasExtension(node: CcFlatNode): boolean {
    if (!node || !node.children) {
      return false;
    }
    for (const child of node.children) {
      if (child instanceof AsccpFlatNode) {
        if (child.asccpNode.propertyTerm === 'Extension') {
          return true;
        }
      }
    }
    return false;
  }

  addChangeListener(listener: ChangeListener<CcFlatNode>) {
    if (listener) {
      this.changeListeners.push(listener);
    }
  }

  fireChangeEvent(propertyName: string, val: any) {
    this.changeListeners.forEach(listener => {
      listener.onChange(this, propertyName, val);
    });
  }

  get parents(): CcFlatNode[] {
    let node: CcFlatNode = this;
    const result: CcFlatNode[] = [node];
    while (node.parent) {
      result.push(node.parent as CcFlatNode);
      node = node.parent as CcFlatNode;
    }
    return result.reverse();
  }

  get isChanged(): boolean {
    return (!!this.detail) ? this.detail.isChanged : false;
  }

  get hashCode(): number {
    return (!!this.detail) ? this.detail.hashCode : 0;
  }

  reset() {
    if (!!this.detail) {
      this.detail.reset();
    }
  }

  deprecated: boolean;

  get inhibited() {
    return false;
  }
}

export class AccFlatNode extends CcFlatNodeImpl {
  accNode: CcGraphNode;

  constructor(accNode: CcGraphNode) {
    super();
    this.accNode = accNode;
    this.deprecated = accNode.deprecated;
  }

  get type(): string {
    return 'ACC';
  }

  get typeClass(): string {
    return this.type;
  }

  get guid(): string {
    return this.accNode.guid;
  }

  get name(): string {
    if (this.detail) {
      return (this.detail as CcAccNodeDetail).den;
    }
    return this.accNode.objectClassTerm + '. Details';
  }

  set name(val: string) {
    if (this.detail) {
      (this.detail as CcAccNodeDetail).objectClassTerm = val;
    }
    this.accNode.objectClassTerm = val;
  }

  get den(): string {
    return this.name;
  }

  get manifestId(): number {
    return this.accNode.manifestId;
  }

  get releaseId(): number {
    return this.detail ? (this.detail as CcAccNodeDetail).releaseId : undefined;
  }

  get accManifestId(): number {
    return this.manifestId;
  }
}

export class AsccpFlatNode extends CcFlatNodeImpl {
  asccpNode: CcGraphNode;
  asccNode?: CcGraphNode;

  constructor(asccpNode: CcGraphNode,
              asccNode?: CcGraphNode) {
    super();
    this.asccpNode = asccpNode;
    this.asccNode = asccNode;
    this.deprecated = asccpNode.deprecated || (!!asccNode && asccNode.deprecated);
    this.expandable = true;
  }

  get type(): string {
    return 'ASCCP';
  }

  get typeClass(): string {
    return this.type;
  }

  get guid(): string {
    return this.asccpNode.guid;
  }

  get name(): string {
    if (this.detail) {
      return (this.detail as CcAsccpNodeDetail).asccp.propertyTerm;
    }
    return this.asccpNode.propertyTerm;
  }

  set name(val: string) {
    if (this.detail) {
      (this.detail as CcAsccpNodeDetail).asccp.propertyTerm = val;
    }
    this.asccpNode.propertyTerm = val;
  }

  get manifestId(): number {
    return this.asccpNode.manifestId;
  }

  get releaseId(): number {
    return this.detail ? (this.detail as CcAsccpNodeDetail).asccp.releaseId : undefined;
  }

  get asccManifestId(): number {
    if (this.asccNode) {
      return this.asccNode.manifestId;
    }
    return undefined;
  }

  get asccpManifestId(): number {
    return this.manifestId;
  }

  get isUserExtensionGroup(): boolean {
    return this.asccpNode.propertyTerm.endsWith('User Extension Group');
  }
}

export class BccpFlatNode extends CcFlatNodeImpl {
  bccNode?: CcGraphNode;
  bccpNode: CcGraphNode;
  bdtNode: CcGraphNode;

  constructor(bccpNode: CcGraphNode,
              bdtNode: CcGraphNode,
              bccNode?: CcGraphNode) {
    super();
    this.bccpNode = bccpNode;
    this.bdtNode = bdtNode;
    this.bccNode = bccNode;
    this.deprecated = bccpNode.deprecated || bdtNode.deprecated || (!!bccNode && bccNode.deprecated);
  }

  get type(): string {
    return 'BCCP';
  }

  get typeClass(): string {
    if (this.bccNode && this.bccNode.entityType === 'Attribute') {
      return this.type + '-attribute';
    }
    return this.type;
  }

  get guid(): string {
    return this.bccpNode.guid;
  }

  get name(): string {
    if (this.detail) {
      return (this.detail as CcBccpNodeDetail).bccp.propertyTerm;
    }
    return this.bccpNode.propertyTerm;
  }

  set name(val: string) {
    if (this.detail) {
      (this.detail as CcBccpNodeDetail).bccp.propertyTerm = val;
    }
    this.bccpNode.propertyTerm = val;
  }

  get entityType(): string {
    return this.bccNode ? this.bccNode.entityType : undefined;
  }

  get manifestId(): number {
    return this.bccpNode.manifestId;
  }

  get releaseId(): number {
    return this.detail ? (this.detail as CcBccpNodeDetail).bccp.releaseId : undefined;
  }

  get bccManifestId(): number {
    if (this.bccNode) {
      return this.bccNode.manifestId;
    }
    return undefined;
  }

  get bccpManifestId(): number {
    return this.manifestId;
  }

  get bdtManifestId(): number {
    if (this.bdtNode) {
      return this.bdtNode.manifestId;
    }
    return undefined;
  }
}

export class DtFlatNode extends CcFlatNodeImpl {
  dtNode: CcGraphNode;

  constructor(dtNode: CcGraphNode) {
    super();
    this.dtNode = dtNode;
    this.deprecated = dtNode.deprecated;
  }

  get type(): string {
    return 'DT';
  }

  get typeClass(): string {
    return this.type;
  }

  get guid(): string {
    return this.dtNode.guid;
  }

  get name(): string {
    if (this.detail) {
      return (this.detail as CcDtNodeDetail).den;
    }
    return this.dtNode.den;
  }

  set name(val: string) {
    if (this.detail) {
      (this.detail as CcDtNodeDetail).den = val;
    }
    this.dtNode.den = val;
  }

  get manifestId(): number {
    return this.dtNode.manifestId;
  }

  get releaseId(): number {
    return this.detail ? (this.detail as CcDtNodeDetail).releaseId : undefined;
  }

  get den(): string {
    return this.dtNode.den;
  }

  get basedManifestId(): number {
    return this.detail ? (this.detail as CcDtNodeDetail).basedBdtManifestId : undefined;
  }
}

export class DtScFlatNode extends CcFlatNodeImpl {
  dtScNode: CcGraphNode;

  constructor(dtScNode: CcGraphNode) {
    super();
    this.dtScNode = dtScNode;
  }

  get type(): string {
    return 'DT_SC';
  }

  get typeClass(): string {
    return this.type;
  }

  get guid(): string {
    return this.dtScNode.guid;
  }

  get name(): string {
    const propertyTerm = this.dtScNode.propertyTerm || '';
    const middle = propertyTerm.replace(this.dtScNode.representationTerm, '').trim();
    if (middle) {
      return this.dtScNode.objectClassTerm + '. '
        + middle + '. '
        + this.dtScNode.representationTerm;
    }
    return this.dtScNode.objectClassTerm + '. '
      + this.dtScNode.representationTerm;
  }

  set name(val: string) {
    throw Error('Unsupported operation');
  }

  get den(): string {
    return this.name;
  }

  set den(val: string) {
  }

  get releaseId(): number {
    return this.detail ? (this.detail as CcBdtScNodeDetail).releaseId : undefined;
  }

  get manifestId(): number {
    return this.dtScNode.manifestId;
  }

  get bdtScManifestId(): number {
    return this.manifestId;
  }

  get inhibited(): boolean {
    return this.dtScNode.cardinalityMin === 0 && this.dtScNode.cardinalityMax === 0;
  }

  get removeAble(): boolean {
    return !(this.dtScNode.basedDtScId > 0);
  }
}

export class VSCcTreeDataSource<T extends CcFlatNode> extends VSFlatTreeDataSource<T> implements ChangeListener<T> {

  changedNodes: T[] = [];
  private _listeners: ChangeListener<T>[];

  constructor(treeControl: VSFlatTreeControl<T>, data: T[],
              public service: CcNodeService,
              listeners?: ChangeListener<T>[]) {
    super(treeControl, data);
    this._listeners = listeners || [];
    data.forEach(e => this._addChangeListener(e));
  }

  _addChangeListener(node: T) {
    node.addChangeListener(this);
    this._listeners.forEach(listener => node.addChangeListener(listener));
  }

  onChange(entity: T, propertyName: string, val: any) {
    const idx = this.changedNodes.indexOf(entity);
    if (entity.isChanged) {
      if (idx === -1) {
        this.changedNodes.push(entity);
      }
    } else {
      if (idx > -1) {
        this.changedNodes.splice(idx, 1);
      }
    }
  }

  getNodeFullIndex(node: T) {
    return this.cachedData.indexOf(node);
  }

  getNodeByFullIndex(index: number) {
    return this.cachedData.length > index ? this.cachedData[index] : undefined;
  }

  loadDetail(node: CcFlatNode, callbackFn?) {
    if (node.detail) {
      return callbackFn && callbackFn(node);
    }

    this.service.getDetail(node).subscribe(detail => {
      node.detail = detail;
      return callbackFn && callbackFn(detail);
    });
  }

  getRootNode(): CcFlatNode {
    return this.data[0];
  }

  getChanged(): CcFlatNode[] {
    return this.cachedData.filter(e => e.isChanged);
  }

  resetChanged() {
    this.changedNodes.forEach(e => {
      e.reset();
    });
    this.changedNodes = [];
  }

  insertNodes(nodes: T[], siblingIndex: number) {
    if (!nodes || nodes.length === 0) {
      return;
    }
    const cachedData = this.cachedData;
    let start;
    if (siblingIndex === -1 || siblingIndex >= this.getRootNode().children.length) {
      start = cachedData.length;
    } else {
      if (this.getRootNode().children.length === 0) {
        start = 1;
      } else {
        start = cachedData.indexOf(this.getRootNode().children[siblingIndex] as T);
      }
    }

    const rootChildren = this.getRootNode().children;
    rootChildren.splice(siblingIndex, 0, nodes[0]);
    cachedData[0].children = rootChildren;
    nodes[0].parent = this.getRootNode();

    const head = cachedData.slice(0, start);
    const tail = cachedData.slice(start, cachedData.length);
    this.cachedData = head.concat(nodes).concat(tail);
    nodes.forEach(e => this._addChangeListener(e));
  }

  removeNodes(siblingIndex: number) {
    const cachedData = this.cachedData;
    let start;
    start = cachedData.indexOf(this.getRootNode().children[siblingIndex] as T);
    let end = cachedData.findIndex((e, index) => index > start && e.level === 1);
    if (end === -1) {
      end = cachedData.length;
    }

    const rootChildren = this.getRootNode().children;
    cachedData[0].children = rootChildren;
    rootChildren.splice(siblingIndex, 1);

    cachedData.splice(start, end - start);
    this.cachedData = cachedData;
  }

  getNodesByLevelAndIndex(nodes: T[], siblingIndex: number) {
    const siblings = nodes.filter(e => e.level === 1);
    if (siblings.length < siblingIndex) {
      return [];
    }
    if (siblingIndex === -1) {
      siblingIndex = siblings.length - 1;
    }
    const start = nodes.indexOf(siblings[siblingIndex]);
    let end = nodes.findIndex((e, index) => index > start && e.level === 1);
    if (end === -1) {
      end = nodes.length;
    }
    return nodes.slice(start, end);
  }
}

export class CcFlatNodeFlattener implements FlatNodeFlattener<CcFlatNode> {
  _ccGraph: CcGraph;
  _manifestId: number;
  _type: string;
  _listeners: FlatNodeFlattenerListener<CcFlatNode>[] = [];

  constructor(ccGraph: CcGraph, type: string, manifestId: number) {
    this._ccGraph = ccGraph;
    this._type = type;
    this._manifestId = manifestId;
  }

  get key(): string {
    return this._type.toUpperCase() + '-' + this._manifestId;
  }

  addListener(listener: FlatNodeFlattenerListener<CcFlatNode>) {
    this._listeners.push(listener);
  }

  toAccNode(accNode: CcGraphNode, parent: CcFlatNode) {
    const node = new AccFlatNode(accNode);
    node.state = accNode.state;
    node.deprecated = accNode.deprecated;
    node.level = parent.level + 1;
    node.parent = parent;
    return node;
  }

  toAsccpNode(asccNode: CcGraphNode, parent: CcFlatNode) {
    const asccpNode = next(this._ccGraph, asccNode);
    const node = new AsccpFlatNode(asccpNode, asccNode);
    node.state = asccpNode.state;
    node.deprecated = asccpNode.deprecated || asccNode.deprecated;
    node.level = parent.level + 1;
    node.parent = parent;
    node.isCycle = this.detectCycle(node);
    return node;
  }

  toBccpNode(bccNode: CcGraphNode, parent: CcFlatNode) {
    const bccpNode = next(this._ccGraph, bccNode);
    const bdtNode = next(this._ccGraph, bccpNode);
    const node = new BccpFlatNode(bccpNode, bdtNode, bccNode);
    node.deprecated = bccpNode.deprecated || bccNode.deprecated || bdtNode.deprecated;
    node.state = bccpNode.state;
    node.level = parent.level + 1;
    node.parent = parent;
    return node;
  }

  toDtScNode(bdtScNode: CcGraphNode, parent: CcFlatNode) {
    const node = new DtScFlatNode(bdtScNode);
    node.deprecated = bdtScNode.deprecated;
    node.state = bdtScNode.state;
    node.level = parent.level + 1;
    node.parent = parent;
    return node;
  }

  fireEvent(node: CcFlatNode) {
    this._listeners.forEach(listener => {
      listener.onFlatten(node);
    });
  }

  flatten(excludeSCs?: boolean, initialExpandDepth?: number): CcFlatNode[] {
    let node;
    if (this._type === 'ACC') {
      const accNode = this._ccGraph.graph.nodes[this.key];
      node = new AccFlatNode(accNode);
    } else if (this._type === 'ASCCP') {
      const asccpNode = this._ccGraph.graph.nodes[this.key];
      node = new AsccpFlatNode(asccpNode);
    } else if (this._type === 'BCCP') {
      const bccpNode = this._ccGraph.graph.nodes[this.key];
      const bdtNode = next(this._ccGraph, bccpNode);
      node = new BccpFlatNode(bccpNode, bdtNode);
    } else if (this._type === 'DT') {
      const bdtNode = this._ccGraph.graph.nodes[this.key];
      node = new DtFlatNode(bdtNode);
    }
    node.level = 0;
    this.fireEvent(node);

    const nodes = [node,];
    this._doFlatten(nodes, node, excludeSCs, initialExpandDepth);
    return nodes;
  }

  _doFlatten(nodes: CcFlatNode[], node: CcFlatNode, excludeSCs?: boolean, depth?: number) {
    if (excludeSCs && node.type === 'BCCP') {
      node.children = [];
      node.expandable = this.hasDtScChildren((node as BccpFlatNode).bdtNode);
    } else {
      const children = this.getChildren(node);
      node.expandable = children.length > 0;

      if (depth === 0) {
        node.children = [];
      } else {
        node.children = children;
        node.children.map(e => e as CcFlatNode).forEach(e => {
          nodes.push(e);
          this.fireEvent(e);
          if (e instanceof AsccpFlatNode && e.isCycle) {
            return;
          }
          this._doFlatten(nodes, e, excludeSCs, depth - 1);
        });
      }
    }
  }

  detectCycle(node: AsccpFlatNode): boolean {
    const asccpManifestId = node.asccpNode.manifestId;
    let cur = node.parent;
    while (cur) {
      if (cur instanceof AsccpFlatNode && (cur as AsccpFlatNode).asccpManifestId === asccpManifestId) {
        return true;
      }
      cur = cur.parent;
    }
    return false;
  }

  afterAsccpFlatNode(node: AsccpFlatNode) {
  }

  afterBccpFlatNode(node: BccpFlatNode) {
  }

  afterBdtScFlatNode(node: BbieScFlatNode) {
  }

  getChildren(node: CcFlatNode): CcFlatNode[] {
    const nodes = this._ccGraph.graph.nodes;
    const edges = this._ccGraph.graph.edges;

    if (node instanceof BccpFlatNode) {
      if ((node as BccpFlatNode).bccNode && (node as BccpFlatNode).bccNode.entityType === 'Attribute') {
        return [];
      }
    }

    const edge = edges[getKey(node)];
    const targets = (!!edge) ? edge.targets : [];
    if (!targets || targets.length === 0) {
      return [];
    }

    let children = [];

    if (node instanceof DtFlatNode) {
      targets.forEach(target => {
        children.push(this.toDtScNode(nodes[target], node));
      });
      return children;
    }

    targets.forEach(target => {
      if (target.startsWith('ACC-')) {
        children.push(this.toAccNode(nodes[target], node));
      } else if (target.startsWith('ASCC-')) {
        const asccpNode = this.toAsccpNode(nodes[target], node);
        if (asccpNode.isUserExtensionGroup) {
          const uegAccNode = this.getChildren(asccpNode)[0];
          children.push(...this.getChildren(uegAccNode).map(e => {
            e.level = node.level + 1;
            e.parent = node;
            return e;
          }));
        } else {
          children.push(asccpNode);
        }
      } else if (target.startsWith('BCC-')) {
        children.push(this.toBccpNode(nodes[target], node));
      } else if (target.startsWith('DT-')) {
        const bdtScEdges = edges[target];
        if (bdtScEdges) {
          bdtScEdges.targets.map(e => nodes[e]).filter(e => e.cardinalityMax > 0).forEach(e => {
            children.push(this.toDtScNode(e, node));
          });
        }
      }
    });
    return children;
  }

  expand(node: CcFlatNode) {
    node.children = this.getChildren(node);
    node.expandable = node.children.length > 0;
    node.children.map(e => e as CcFlatNode).forEach(e => {
      this.fireEvent(e);
      if (e instanceof AsccpFlatNode && e.isCycle) {
        return;
      }
      e.expandable = this.getChildren(e).length > 0;
    });
  }

  hasDtScChildren(node: CcGraphNode): boolean {
    const nodes = this._ccGraph.graph.nodes;
    const edges = this._ccGraph.graph.edges;

    const edge = edges[getKey(node)];
    const targets = (!!edge) ? edge.targets : [];
    if (!targets || targets.length === 0) {
      return false;
    }

    switch (node.type) {
      case 'DT':
        return targets.map(e => nodes[e]).filter(e => e.cardinalityMax > 0).length > 0;

      default :
        return false;
    }
  }
}
