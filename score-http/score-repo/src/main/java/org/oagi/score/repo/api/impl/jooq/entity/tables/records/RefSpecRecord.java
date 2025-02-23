/*
 * This file is generated by jOOQ.
 */
package org.oagi.score.repo.api.impl.jooq.entity.tables.records;


import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;
import org.jooq.types.ULong;
import org.oagi.score.repo.api.impl.jooq.entity.tables.RefSpec;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RefSpecRecord extends UpdatableRecordImpl<RefSpecRecord> implements Record2<ULong, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>oagi.ref_spec.ref_spec_id</code>.
     */
    public void setRefSpecId(ULong value) {
        set(0, value);
    }

    /**
     * Getter for <code>oagi.ref_spec.ref_spec_id</code>.
     */
    public ULong getRefSpecId() {
        return (ULong) get(0);
    }

    /**
     * Setter for <code>oagi.ref_spec.spec</code>.
     */
    public void setSpec(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>oagi.ref_spec.spec</code>.
     */
    public String getSpec() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<ULong> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<ULong, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<ULong, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<ULong> field1() {
        return RefSpec.REF_SPEC.REF_SPEC_ID;
    }

    @Override
    public Field<String> field2() {
        return RefSpec.REF_SPEC.SPEC;
    }

    @Override
    public ULong component1() {
        return getRefSpecId();
    }

    @Override
    public String component2() {
        return getSpec();
    }

    @Override
    public ULong value1() {
        return getRefSpecId();
    }

    @Override
    public String value2() {
        return getSpec();
    }

    @Override
    public RefSpecRecord value1(ULong value) {
        setRefSpecId(value);
        return this;
    }

    @Override
    public RefSpecRecord value2(String value) {
        setSpec(value);
        return this;
    }

    @Override
    public RefSpecRecord values(ULong value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached RefSpecRecord
     */
    public RefSpecRecord() {
        super(RefSpec.REF_SPEC);
    }

    /**
     * Create a detached, initialised RefSpecRecord
     */
    public RefSpecRecord(ULong refSpecId, String spec) {
        super(RefSpec.REF_SPEC);

        setRefSpecId(refSpecId);
        setSpec(spec);
    }
}
