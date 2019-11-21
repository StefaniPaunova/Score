/*
 * This file is generated by jOOQ.
 */
package org.oagi.srt.entity.jooq.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row4;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
import org.jooq.types.ULong;
import org.oagi.srt.entity.jooq.Indexes;
import org.oagi.srt.entity.jooq.Keys;
import org.oagi.srt.entity.jooq.Oagi;
import org.oagi.srt.entity.jooq.tables.records.DtUsageRuleRecord;


/**
 * This is an intersection table. Per CCTS, a usage rule may be reused. This 
 * table allows m-m relationships between the usage rule and the DT content 
 * component and usage rules and DT supplementary component. In a particular 
 * record, either a TARGET_DT_ID or TARGET_DT_SC_ID must be present but not 
 * both.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DtUsageRule extends TableImpl<DtUsageRuleRecord> {

    private static final long serialVersionUID = 756956446;

    /**
     * The reference instance of <code>oagi.dt_usage_rule</code>
     */
    public static final DtUsageRule DT_USAGE_RULE = new DtUsageRule();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<DtUsageRuleRecord> getRecordType() {
        return DtUsageRuleRecord.class;
    }

    /**
     * The column <code>oagi.dt_usage_rule.dt_usage_rule_id</code>. Primary key of the table.
     */
    public final TableField<DtUsageRuleRecord, ULong> DT_USAGE_RULE_ID = createField(DSL.name("dt_usage_rule_id"), org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false).identity(true), this, "Primary key of the table.");

    /**
     * The column <code>oagi.dt_usage_rule.assigned_usage_rule_id</code>. Foreign key to the USAGE_RULE table indicating the usage rule assigned to the DT content component or DT_SC.
     */
    public final TableField<DtUsageRuleRecord, ULong> ASSIGNED_USAGE_RULE_ID = createField(DSL.name("assigned_usage_rule_id"), org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "Foreign key to the USAGE_RULE table indicating the usage rule assigned to the DT content component or DT_SC.");

    /**
     * The column <code>oagi.dt_usage_rule.target_dt_id</code>. Foreing key to the DT_ID for assigning a usage rule to the corresponding DT content component.
     */
    public final TableField<DtUsageRuleRecord, ULong> TARGET_DT_ID = createField(DSL.name("target_dt_id"), org.jooq.impl.SQLDataType.BIGINTUNSIGNED, this, "Foreing key to the DT_ID for assigning a usage rule to the corresponding DT content component.");

    /**
     * The column <code>oagi.dt_usage_rule.target_dt_sc_id</code>. Foreing key to the DT_SC_ID for assigning a usage rule to the corresponding DT_SC.
     */
    public final TableField<DtUsageRuleRecord, ULong> TARGET_DT_SC_ID = createField(DSL.name("target_dt_sc_id"), org.jooq.impl.SQLDataType.BIGINTUNSIGNED, this, "Foreing key to the DT_SC_ID for assigning a usage rule to the corresponding DT_SC.");

    /**
     * Create a <code>oagi.dt_usage_rule</code> table reference
     */
    public DtUsageRule() {
        this(DSL.name("dt_usage_rule"), null);
    }

    /**
     * Create an aliased <code>oagi.dt_usage_rule</code> table reference
     */
    public DtUsageRule(String alias) {
        this(DSL.name(alias), DT_USAGE_RULE);
    }

    /**
     * Create an aliased <code>oagi.dt_usage_rule</code> table reference
     */
    public DtUsageRule(Name alias) {
        this(alias, DT_USAGE_RULE);
    }

    private DtUsageRule(Name alias, Table<DtUsageRuleRecord> aliased) {
        this(alias, aliased, null);
    }

    private DtUsageRule(Name alias, Table<DtUsageRuleRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("This is an intersection table. Per CCTS, a usage rule may be reused. This table allows m-m relationships between the usage rule and the DT content component and usage rules and DT supplementary component. In a particular record, either a TARGET_DT_ID or TARGET_DT_SC_ID must be present but not both."));
    }

    public <O extends Record> DtUsageRule(Table<O> child, ForeignKey<O, DtUsageRuleRecord> key) {
        super(child, key, DT_USAGE_RULE);
    }

    @Override
    public Schema getSchema() {
        return Oagi.OAGI;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.DT_USAGE_RULE_DT_USAGE_RULE_ASSIGNED_USAGE_RULE_ID_FK, Indexes.DT_USAGE_RULE_DT_USAGE_RULE_TARGET_DT_ID_FK, Indexes.DT_USAGE_RULE_DT_USAGE_RULE_TARGET_DT_SC_ID_FK, Indexes.DT_USAGE_RULE_PRIMARY);
    }

    @Override
    public Identity<DtUsageRuleRecord, ULong> getIdentity() {
        return Keys.IDENTITY_DT_USAGE_RULE;
    }

    @Override
    public UniqueKey<DtUsageRuleRecord> getPrimaryKey() {
        return Keys.KEY_DT_USAGE_RULE_PRIMARY;
    }

    @Override
    public List<UniqueKey<DtUsageRuleRecord>> getKeys() {
        return Arrays.<UniqueKey<DtUsageRuleRecord>>asList(Keys.KEY_DT_USAGE_RULE_PRIMARY);
    }

    @Override
    public List<ForeignKey<DtUsageRuleRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<DtUsageRuleRecord, ?>>asList(Keys.DT_USAGE_RULE_ASSIGNED_USAGE_RULE_ID_FK, Keys.DT_USAGE_RULE_TARGET_DT_ID_FK, Keys.DT_USAGE_RULE_TARGET_DT_SC_ID_FK);
    }

    public UsageRule usageRule() {
        return new UsageRule(this, Keys.DT_USAGE_RULE_ASSIGNED_USAGE_RULE_ID_FK);
    }

    public Dt dt() {
        return new Dt(this, Keys.DT_USAGE_RULE_TARGET_DT_ID_FK);
    }

    public DtSc dtSc() {
        return new DtSc(this, Keys.DT_USAGE_RULE_TARGET_DT_SC_ID_FK);
    }

    @Override
    public DtUsageRule as(String alias) {
        return new DtUsageRule(DSL.name(alias), this);
    }

    @Override
    public DtUsageRule as(Name alias) {
        return new DtUsageRule(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public DtUsageRule rename(String name) {
        return new DtUsageRule(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public DtUsageRule rename(Name name) {
        return new DtUsageRule(name, null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<ULong, ULong, ULong, ULong> fieldsRow() {
        return (Row4) super.fieldsRow();
    }
}
