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
import org.jooq.Row5;
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
import org.oagi.srt.entity.jooq.tables.records.CtxSchemeValueRecord;


/**
 * This table stores the context scheme values for a particular context scheme 
 * in the CTX_SCHEME table.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CtxSchemeValue extends TableImpl<CtxSchemeValueRecord> {

    private static final long serialVersionUID = -1294537249;

    /**
     * The reference instance of <code>oagi.ctx_scheme_value</code>
     */
    public static final CtxSchemeValue CTX_SCHEME_VALUE = new CtxSchemeValue();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CtxSchemeValueRecord> getRecordType() {
        return CtxSchemeValueRecord.class;
    }

    /**
     * The column <code>oagi.ctx_scheme_value.ctx_scheme_value_id</code>. Primary, internal database key.
     */
    public final TableField<CtxSchemeValueRecord, ULong> CTX_SCHEME_VALUE_ID = createField(DSL.name("ctx_scheme_value_id"), org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false).identity(true), this, "Primary, internal database key.");

    /**
     * The column <code>oagi.ctx_scheme_value.guid</code>. GUID of the context scheme value. Per OAGIS, a GUID is of the form "oagis-id-" followed by a 32 Hex character sequence.
     */
    public final TableField<CtxSchemeValueRecord, String> GUID = createField(DSL.name("guid"), org.jooq.impl.SQLDataType.VARCHAR(41).nullable(false), this, "GUID of the context scheme value. Per OAGIS, a GUID is of the form \"oagis-id-\" followed by a 32 Hex character sequence.");

    /**
     * The column <code>oagi.ctx_scheme_value.value</code>. A short value for the scheme value similar to the code list value.
     */
    public final TableField<CtxSchemeValueRecord, String> VALUE = createField(DSL.name("value"), org.jooq.impl.SQLDataType.VARCHAR(45).nullable(false), this, "A short value for the scheme value similar to the code list value.");

    /**
     * The column <code>oagi.ctx_scheme_value.meaning</code>. The description, explanatiion of the scheme value.
     */
    public final TableField<CtxSchemeValueRecord, String> MEANING = createField(DSL.name("meaning"), org.jooq.impl.SQLDataType.CLOB, this, "The description, explanatiion of the scheme value.");

    /**
     * The column <code>oagi.ctx_scheme_value.owner_ctx_scheme_id</code>. Foreign key to the CTX_SCHEME table. It identifies the context scheme, to which this scheme value belongs.
     */
    public final TableField<CtxSchemeValueRecord, ULong> OWNER_CTX_SCHEME_ID = createField(DSL.name("owner_ctx_scheme_id"), org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "Foreign key to the CTX_SCHEME table. It identifies the context scheme, to which this scheme value belongs.");

    /**
     * Create a <code>oagi.ctx_scheme_value</code> table reference
     */
    public CtxSchemeValue() {
        this(DSL.name("ctx_scheme_value"), null);
    }

    /**
     * Create an aliased <code>oagi.ctx_scheme_value</code> table reference
     */
    public CtxSchemeValue(String alias) {
        this(DSL.name(alias), CTX_SCHEME_VALUE);
    }

    /**
     * Create an aliased <code>oagi.ctx_scheme_value</code> table reference
     */
    public CtxSchemeValue(Name alias) {
        this(alias, CTX_SCHEME_VALUE);
    }

    private CtxSchemeValue(Name alias, Table<CtxSchemeValueRecord> aliased) {
        this(alias, aliased, null);
    }

    private CtxSchemeValue(Name alias, Table<CtxSchemeValueRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("This table stores the context scheme values for a particular context scheme in the CTX_SCHEME table."));
    }

    public <O extends Record> CtxSchemeValue(Table<O> child, ForeignKey<O, CtxSchemeValueRecord> key) {
        super(child, key, CTX_SCHEME_VALUE);
    }

    @Override
    public Schema getSchema() {
        return Oagi.OAGI;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.CTX_SCHEME_VALUE_CTX_SCHEME_VALUE_OWNER_CTX_SCHEME_ID_FK, Indexes.CTX_SCHEME_VALUE_CTX_SCHEME_VALUE_UK1, Indexes.CTX_SCHEME_VALUE_PRIMARY);
    }

    @Override
    public Identity<CtxSchemeValueRecord, ULong> getIdentity() {
        return Keys.IDENTITY_CTX_SCHEME_VALUE;
    }

    @Override
    public UniqueKey<CtxSchemeValueRecord> getPrimaryKey() {
        return Keys.KEY_CTX_SCHEME_VALUE_PRIMARY;
    }

    @Override
    public List<UniqueKey<CtxSchemeValueRecord>> getKeys() {
        return Arrays.<UniqueKey<CtxSchemeValueRecord>>asList(Keys.KEY_CTX_SCHEME_VALUE_PRIMARY, Keys.KEY_CTX_SCHEME_VALUE_CTX_SCHEME_VALUE_UK1);
    }

    @Override
    public List<ForeignKey<CtxSchemeValueRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<CtxSchemeValueRecord, ?>>asList(Keys.CTX_SCHEME_VALUE_OWNER_CTX_SCHEME_ID_FK);
    }

    public CtxScheme ctxScheme() {
        return new CtxScheme(this, Keys.CTX_SCHEME_VALUE_OWNER_CTX_SCHEME_ID_FK);
    }

    @Override
    public CtxSchemeValue as(String alias) {
        return new CtxSchemeValue(DSL.name(alias), this);
    }

    @Override
    public CtxSchemeValue as(Name alias) {
        return new CtxSchemeValue(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public CtxSchemeValue rename(String name) {
        return new CtxSchemeValue(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public CtxSchemeValue rename(Name name) {
        return new CtxSchemeValue(name, null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<ULong, String, String, String, ULong> fieldsRow() {
        return (Row5) super.fieldsRow();
    }
}
