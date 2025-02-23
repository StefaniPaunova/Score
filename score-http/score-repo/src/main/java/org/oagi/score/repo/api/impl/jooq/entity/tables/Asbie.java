/*
 * This file is generated by jOOQ.
 */
package org.oagi.score.repo.api.impl.jooq.entity.tables;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function19;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row19;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;
import org.jooq.types.ULong;
import org.oagi.score.repo.api.impl.jooq.entity.Indexes;
import org.oagi.score.repo.api.impl.jooq.entity.Keys;
import org.oagi.score.repo.api.impl.jooq.entity.Oagi;
import org.oagi.score.repo.api.impl.jooq.entity.tables.records.AsbieRecord;


/**
 * An ASBIE represents a relationship/association between two ABIEs through an
 * ASBIEP. It is a contextualization of an ASCC.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Asbie extends TableImpl<AsbieRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>oagi.asbie</code>
     */
    public static final Asbie ASBIE = new Asbie();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AsbieRecord> getRecordType() {
        return AsbieRecord.class;
    }

    /**
     * The column <code>oagi.asbie.asbie_id</code>. A internal, primary database
     * key of an ASBIE.
     */
    public final TableField<AsbieRecord, ULong> ASBIE_ID = createField(DSL.name("asbie_id"), SQLDataType.BIGINTUNSIGNED.nullable(false).identity(true), this, "A internal, primary database key of an ASBIE.");

    /**
     * The column <code>oagi.asbie.guid</code>. A globally unique identifier
     * (GUID).
     */
    public final TableField<AsbieRecord, String> GUID = createField(DSL.name("guid"), SQLDataType.CHAR(32).nullable(false), this, "A globally unique identifier (GUID).");

    /**
     * The column <code>oagi.asbie.based_ascc_manifest_id</code>. The
     * BASED_ASCC_MANIFEST_ID column refers to the ASCC_MANIFEST record, which
     * this ASBIE contextualizes.
     */
    public final TableField<AsbieRecord, ULong> BASED_ASCC_MANIFEST_ID = createField(DSL.name("based_ascc_manifest_id"), SQLDataType.BIGINTUNSIGNED.nullable(false), this, "The BASED_ASCC_MANIFEST_ID column refers to the ASCC_MANIFEST record, which this ASBIE contextualizes.");

    /**
     * The column <code>oagi.asbie.path</code>.
     */
    public final TableField<AsbieRecord, String> PATH = createField(DSL.name("path"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>oagi.asbie.hash_path</code>. hash_path generated from
     * the path of the component graph using hash function, so that it is unique
     * in the graph.
     */
    public final TableField<AsbieRecord, String> HASH_PATH = createField(DSL.name("hash_path"), SQLDataType.VARCHAR(64).nullable(false), this, "hash_path generated from the path of the component graph using hash function, so that it is unique in the graph.");

    /**
     * The column <code>oagi.asbie.from_abie_id</code>. A foreign key pointing
     * to the ABIE table. FROM_ABIE_ID is basically  a parent data element
     * (type) of the TO_ASBIEP_ID. FROM_ABIE_ID must be based on the FROM_ACC_ID
     * in the BASED_ASCC_ID except when the FROM_ACC_ID refers to an
     * SEMANTIC_GROUP ACC or USER_EXTENSION_GROUP ACC.
     */
    public final TableField<AsbieRecord, ULong> FROM_ABIE_ID = createField(DSL.name("from_abie_id"), SQLDataType.BIGINTUNSIGNED.nullable(false), this, "A foreign key pointing to the ABIE table. FROM_ABIE_ID is basically  a parent data element (type) of the TO_ASBIEP_ID. FROM_ABIE_ID must be based on the FROM_ACC_ID in the BASED_ASCC_ID except when the FROM_ACC_ID refers to an SEMANTIC_GROUP ACC or USER_EXTENSION_GROUP ACC.");

    /**
     * The column <code>oagi.asbie.to_asbiep_id</code>. A foreign key to the
     * ASBIEP table. TO_ASBIEP_ID is basically a child data element of the
     * FROM_ABIE_ID. The TO_ASBIEP_ID must be based on the TO_ASCCP_ID in the
     * BASED_ASCC_ID. the ASBIEP is reused with the OWNER_TOP_LEVEL_ASBIEP is
     * different after joining ASBIE and ASBIEP tables
     */
    public final TableField<AsbieRecord, ULong> TO_ASBIEP_ID = createField(DSL.name("to_asbiep_id"), SQLDataType.BIGINTUNSIGNED, this, "A foreign key to the ASBIEP table. TO_ASBIEP_ID is basically a child data element of the FROM_ABIE_ID. The TO_ASBIEP_ID must be based on the TO_ASCCP_ID in the BASED_ASCC_ID. the ASBIEP is reused with the OWNER_TOP_LEVEL_ASBIEP is different after joining ASBIE and ASBIEP tables");

    /**
     * The column <code>oagi.asbie.definition</code>. Definition to override the
     * ASCC definition. If NULL, it means that the definition should be derived
     * from the based CC on the UI, expression generation, and any API.
     */
    public final TableField<AsbieRecord, String> DEFINITION = createField(DSL.name("definition"), SQLDataType.CLOB, this, "Definition to override the ASCC definition. If NULL, it means that the definition should be derived from the based CC on the UI, expression generation, and any API.");

    /**
     * The column <code>oagi.asbie.cardinality_min</code>. Minimum occurence
     * constraint of the TO_ASBIEP_ID. A valid value is a non-negative integer.
     */
    public final TableField<AsbieRecord, Integer> CARDINALITY_MIN = createField(DSL.name("cardinality_min"), SQLDataType.INTEGER.nullable(false), this, "Minimum occurence constraint of the TO_ASBIEP_ID. A valid value is a non-negative integer.");

    /**
     * The column <code>oagi.asbie.cardinality_max</code>. Maximum occurrence
     * constraint of the TO_ASBIEP_ID. A valid value is an integer from -1 and
     * up. Specifically, -1 means unbounded. 0 means prohibited or not to use.
     */
    public final TableField<AsbieRecord, Integer> CARDINALITY_MAX = createField(DSL.name("cardinality_max"), SQLDataType.INTEGER.nullable(false), this, "Maximum occurrence constraint of the TO_ASBIEP_ID. A valid value is an integer from -1 and up. Specifically, -1 means unbounded. 0 means prohibited or not to use.");

    /**
     * The column <code>oagi.asbie.is_nillable</code>. Indicate whether the
     * TO_ASBIEP_ID is allowed to be null.
     */
    public final TableField<AsbieRecord, Byte> IS_NILLABLE = createField(DSL.name("is_nillable"), SQLDataType.TINYINT.nullable(false).defaultValue(DSL.inline("0", SQLDataType.TINYINT)), this, "Indicate whether the TO_ASBIEP_ID is allowed to be null.");

    /**
     * The column <code>oagi.asbie.remark</code>. This column allows the user to
     * specify very context-specific usage of the BIE. It is different from the
     * DEFINITION column in that the DEFINITION column is a description
     * conveying the meaning of the associated concept. Remarks may be a very
     * implementation specific instruction or others. For example, BOM BOD, as
     * an ACC, is a generic BOM structure. In a particular context, a BOM ABIE
     * can be a Super BOM. Explanation of the Super BOM concept should be
     * captured in the Definition of the ABIE. A remark about that ABIE may be
     * "Type of BOM should be recognized in the BOM/typeCode."
     */
    public final TableField<AsbieRecord, String> REMARK = createField(DSL.name("remark"), SQLDataType.VARCHAR(225), this, "This column allows the user to specify very context-specific usage of the BIE. It is different from the DEFINITION column in that the DEFINITION column is a description conveying the meaning of the associated concept. Remarks may be a very implementation specific instruction or others. For example, BOM BOD, as an ACC, is a generic BOM structure. In a particular context, a BOM ABIE can be a Super BOM. Explanation of the Super BOM concept should be captured in the Definition of the ABIE. A remark about that ABIE may be \"Type of BOM should be recognized in the BOM/typeCode.\"");

    /**
     * The column <code>oagi.asbie.created_by</code>. A foreign key referring to
     * the user who creates the ASBIE. The creator of the ASBIE is also its
     * owner by default. ASBIEs created as children of another ABIE have the
     * same CREATED_BY.
     */
    public final TableField<AsbieRecord, ULong> CREATED_BY = createField(DSL.name("created_by"), SQLDataType.BIGINTUNSIGNED.nullable(false), this, "A foreign key referring to the user who creates the ASBIE. The creator of the ASBIE is also its owner by default. ASBIEs created as children of another ABIE have the same CREATED_BY.");

    /**
     * The column <code>oagi.asbie.last_updated_by</code>. A foreign key
     * referring to the user who has last updated the ASBIE record. 
     */
    public final TableField<AsbieRecord, ULong> LAST_UPDATED_BY = createField(DSL.name("last_updated_by"), SQLDataType.BIGINTUNSIGNED.nullable(false), this, "A foreign key referring to the user who has last updated the ASBIE record. ");

    /**
     * The column <code>oagi.asbie.creation_timestamp</code>. Timestamp when the
     * ASBIE record was first created. ASBIEs created as children of another
     * ABIE have the same CREATION_TIMESTAMP.
     */
    public final TableField<AsbieRecord, LocalDateTime> CREATION_TIMESTAMP = createField(DSL.name("creation_timestamp"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "Timestamp when the ASBIE record was first created. ASBIEs created as children of another ABIE have the same CREATION_TIMESTAMP.");

    /**
     * The column <code>oagi.asbie.last_update_timestamp</code>. The timestamp
     * when the ASBIE was last updated.
     */
    public final TableField<AsbieRecord, LocalDateTime> LAST_UPDATE_TIMESTAMP = createField(DSL.name("last_update_timestamp"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "The timestamp when the ASBIE was last updated.");

    /**
     * The column <code>oagi.asbie.seq_key</code>. This indicates the order of
     * the associations among other siblings. The SEQ_KEY for BIEs is decimal in
     * order to accomodate the removal of inheritance hierarchy and group. For
     * example, children of the most abstract ACC will have SEQ_KEY = 1.1, 1.2,
     * 1.3, and so on; and SEQ_KEY of the next abstraction level ACC will have
     * SEQ_KEY = 2.1, 2.2, 2.3 and so on so forth.
     */
    public final TableField<AsbieRecord, BigDecimal> SEQ_KEY = createField(DSL.name("seq_key"), SQLDataType.DECIMAL(10, 2).nullable(false), this, "This indicates the order of the associations among other siblings. The SEQ_KEY for BIEs is decimal in order to accomodate the removal of inheritance hierarchy and group. For example, children of the most abstract ACC will have SEQ_KEY = 1.1, 1.2, 1.3, and so on; and SEQ_KEY of the next abstraction level ACC will have SEQ_KEY = 2.1, 2.2, 2.3 and so on so forth.");

    /**
     * The column <code>oagi.asbie.is_used</code>. Flag to indicate whether the
     * field/component is used in the content model. It signifies whether the
     * field/component should be generated.
     */
    public final TableField<AsbieRecord, Byte> IS_USED = createField(DSL.name("is_used"), SQLDataType.TINYINT.nullable(false).defaultValue(DSL.inline("0", SQLDataType.TINYINT)), this, "Flag to indicate whether the field/component is used in the content model. It signifies whether the field/component should be generated.");

    /**
     * The column <code>oagi.asbie.owner_top_level_asbiep_id</code>. This is a
     * foreign key to the top-level ASBIEP.
     */
    public final TableField<AsbieRecord, ULong> OWNER_TOP_LEVEL_ASBIEP_ID = createField(DSL.name("owner_top_level_asbiep_id"), SQLDataType.BIGINTUNSIGNED.nullable(false), this, "This is a foreign key to the top-level ASBIEP.");

    private Asbie(Name alias, Table<AsbieRecord> aliased) {
        this(alias, aliased, null);
    }

    private Asbie(Name alias, Table<AsbieRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("An ASBIE represents a relationship/association between two ABIEs through an ASBIEP. It is a contextualization of an ASCC."), TableOptions.table());
    }

    /**
     * Create an aliased <code>oagi.asbie</code> table reference
     */
    public Asbie(String alias) {
        this(DSL.name(alias), ASBIE);
    }

    /**
     * Create an aliased <code>oagi.asbie</code> table reference
     */
    public Asbie(Name alias) {
        this(alias, ASBIE);
    }

    /**
     * Create a <code>oagi.asbie</code> table reference
     */
    public Asbie() {
        this(DSL.name("asbie"), null);
    }

    public <O extends Record> Asbie(Table<O> child, ForeignKey<O, AsbieRecord> key) {
        super(child, key, ASBIE);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Oagi.OAGI;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.asList(Indexes.ASBIE_ASBIE_HASH_PATH_K, Indexes.ASBIE_ASBIE_PATH_K);
    }

    @Override
    public Identity<AsbieRecord, ULong> getIdentity() {
        return (Identity<AsbieRecord, ULong>) super.getIdentity();
    }

    @Override
    public UniqueKey<AsbieRecord> getPrimaryKey() {
        return Keys.KEY_ASBIE_PRIMARY;
    }

    @Override
    public List<ForeignKey<AsbieRecord, ?>> getReferences() {
        return Arrays.asList(Keys.ASBIE_BASED_ASCC_MANIFEST_ID_FK, Keys.ASBIE_FROM_ABIE_ID_FK, Keys.ASBIE_TO_ASBIEP_ID_FK, Keys.ASBIE_CREATED_BY_FK, Keys.ASBIE_LAST_UPDATED_BY_FK, Keys.ASBIE_OWNER_TOP_LEVEL_ASBIEP_ID_FK);
    }

    private transient AsccManifest _asccManifest;
    private transient Abie _abie;
    private transient Asbiep _asbiep;
    private transient AppUser _asbieCreatedByFk;
    private transient AppUser _asbieLastUpdatedByFk;
    private transient TopLevelAsbiep _topLevelAsbiep;

    /**
     * Get the implicit join path to the <code>oagi.ascc_manifest</code> table.
     */
    public AsccManifest asccManifest() {
        if (_asccManifest == null)
            _asccManifest = new AsccManifest(this, Keys.ASBIE_BASED_ASCC_MANIFEST_ID_FK);

        return _asccManifest;
    }

    /**
     * Get the implicit join path to the <code>oagi.abie</code> table.
     */
    public Abie abie() {
        if (_abie == null)
            _abie = new Abie(this, Keys.ASBIE_FROM_ABIE_ID_FK);

        return _abie;
    }

    /**
     * Get the implicit join path to the <code>oagi.asbiep</code> table.
     */
    public Asbiep asbiep() {
        if (_asbiep == null)
            _asbiep = new Asbiep(this, Keys.ASBIE_TO_ASBIEP_ID_FK);

        return _asbiep;
    }

    /**
     * Get the implicit join path to the <code>oagi.app_user</code> table, via
     * the <code>asbie_created_by_fk</code> key.
     */
    public AppUser asbieCreatedByFk() {
        if (_asbieCreatedByFk == null)
            _asbieCreatedByFk = new AppUser(this, Keys.ASBIE_CREATED_BY_FK);

        return _asbieCreatedByFk;
    }

    /**
     * Get the implicit join path to the <code>oagi.app_user</code> table, via
     * the <code>asbie_last_updated_by_fk</code> key.
     */
    public AppUser asbieLastUpdatedByFk() {
        if (_asbieLastUpdatedByFk == null)
            _asbieLastUpdatedByFk = new AppUser(this, Keys.ASBIE_LAST_UPDATED_BY_FK);

        return _asbieLastUpdatedByFk;
    }

    /**
     * Get the implicit join path to the <code>oagi.top_level_asbiep</code>
     * table.
     */
    public TopLevelAsbiep topLevelAsbiep() {
        if (_topLevelAsbiep == null)
            _topLevelAsbiep = new TopLevelAsbiep(this, Keys.ASBIE_OWNER_TOP_LEVEL_ASBIEP_ID_FK);

        return _topLevelAsbiep;
    }

    @Override
    public Asbie as(String alias) {
        return new Asbie(DSL.name(alias), this);
    }

    @Override
    public Asbie as(Name alias) {
        return new Asbie(alias, this);
    }

    @Override
    public Asbie as(Table<?> alias) {
        return new Asbie(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Asbie rename(String name) {
        return new Asbie(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Asbie rename(Name name) {
        return new Asbie(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Asbie rename(Table<?> name) {
        return new Asbie(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row19 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row19<ULong, String, ULong, String, String, ULong, ULong, String, Integer, Integer, Byte, String, ULong, ULong, LocalDateTime, LocalDateTime, BigDecimal, Byte, ULong> fieldsRow() {
        return (Row19) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function19<? super ULong, ? super String, ? super ULong, ? super String, ? super String, ? super ULong, ? super ULong, ? super String, ? super Integer, ? super Integer, ? super Byte, ? super String, ? super ULong, ? super ULong, ? super LocalDateTime, ? super LocalDateTime, ? super BigDecimal, ? super Byte, ? super ULong, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function19<? super ULong, ? super String, ? super ULong, ? super String, ? super String, ? super ULong, ? super ULong, ? super String, ? super Integer, ? super Integer, ? super Byte, ? super String, ? super ULong, ? super ULong, ? super LocalDateTime, ? super LocalDateTime, ? super BigDecimal, ? super Byte, ? super ULong, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
