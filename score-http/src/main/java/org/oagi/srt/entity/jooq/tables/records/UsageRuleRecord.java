/*
 * This file is generated by jOOQ.
 */
package org.oagi.srt.entity.jooq.tables.records;


import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;
import org.jooq.types.ULong;
import org.oagi.srt.entity.jooq.tables.UsageRule;


/**
 * This table captures a usage rule information. A usage rule may be expressed 
 * in multiple expressions. Each expression is captured in the USAGE_RULE_EXPRESSION 
 * table. To capture a description of a usage rule, create a usage rule expression 
 * with the unstructured constraint type.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UsageRuleRecord extends UpdatableRecordImpl<UsageRuleRecord> implements Record3<ULong, String, Integer> {

    private static final long serialVersionUID = 971805742;

    /**
     * Setter for <code>oagi.usage_rule.usage_rule_id</code>. Primary key of the usage rule.
     */
    public void setUsageRuleId(ULong value) {
        set(0, value);
    }

    /**
     * Getter for <code>oagi.usage_rule.usage_rule_id</code>. Primary key of the usage rule.
     */
    public ULong getUsageRuleId() {
        return (ULong) get(0);
    }

    /**
     * Setter for <code>oagi.usage_rule.name</code>. Short nmenomic name of the usage rule.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>oagi.usage_rule.name</code>. Short nmenomic name of the usage rule.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>oagi.usage_rule.condition_type</code>. Condition type according to the CC specification. It is a value list column. 0 = pre-condition, 1 = post-condition, 2 = invariant.
     */
    public void setConditionType(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>oagi.usage_rule.condition_type</code>. Condition type according to the CC specification. It is a value list column. 0 = pre-condition, 1 = post-condition, 2 = invariant.
     */
    public Integer getConditionType() {
        return (Integer) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<ULong> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<ULong, String, Integer> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<ULong, String, Integer> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<ULong> field1() {
        return UsageRule.USAGE_RULE.USAGE_RULE_ID;
    }

    @Override
    public Field<String> field2() {
        return UsageRule.USAGE_RULE.NAME;
    }

    @Override
    public Field<Integer> field3() {
        return UsageRule.USAGE_RULE.CONDITION_TYPE;
    }

    @Override
    public ULong component1() {
        return getUsageRuleId();
    }

    @Override
    public String component2() {
        return getName();
    }

    @Override
    public Integer component3() {
        return getConditionType();
    }

    @Override
    public ULong value1() {
        return getUsageRuleId();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public Integer value3() {
        return getConditionType();
    }

    @Override
    public UsageRuleRecord value1(ULong value) {
        setUsageRuleId(value);
        return this;
    }

    @Override
    public UsageRuleRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public UsageRuleRecord value3(Integer value) {
        setConditionType(value);
        return this;
    }

    @Override
    public UsageRuleRecord values(ULong value1, String value2, Integer value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UsageRuleRecord
     */
    public UsageRuleRecord() {
        super(UsageRule.USAGE_RULE);
    }

    /**
     * Create a detached, initialised UsageRuleRecord
     */
    public UsageRuleRecord(ULong usageRuleId, String name, Integer conditionType) {
        super(UsageRule.USAGE_RULE);

        set(0, usageRuleId);
        set(1, name);
        set(2, conditionType);
    }
}
