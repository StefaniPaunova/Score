/*
 * This file is generated by jOOQ.
 */
package org.oagi.score.repo.api.impl.jooq.entity.tables;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function10;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row10;
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
import org.oagi.score.repo.api.impl.jooq.entity.Keys;
import org.oagi.score.repo.api.impl.jooq.entity.Oagi;
import org.oagi.score.repo.api.impl.jooq.entity.tables.records.AppOauth2UserRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AppOauth2User extends TableImpl<AppOauth2UserRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>oagi.app_oauth2_user</code>
     */
    public static final AppOauth2User APP_OAUTH2_USER = new AppOauth2User();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AppOauth2UserRecord> getRecordType() {
        return AppOauth2UserRecord.class;
    }

    /**
     * The column <code>oagi.app_oauth2_user.app_oauth2_user_id</code>. Primary
     * key.
     */
    public final TableField<AppOauth2UserRecord, ULong> APP_OAUTH2_USER_ID = createField(DSL.name("app_oauth2_user_id"), SQLDataType.BIGINTUNSIGNED.nullable(false).identity(true), this, "Primary key.");

    /**
     * The column <code>oagi.app_oauth2_user.app_user_id</code>. A reference to
     * the record in `app_user`. If it is not set, this is treated as a pending
     * record.
     */
    public final TableField<AppOauth2UserRecord, ULong> APP_USER_ID = createField(DSL.name("app_user_id"), SQLDataType.BIGINTUNSIGNED, this, "A reference to the record in `app_user`. If it is not set, this is treated as a pending record.");

    /**
     * The column <code>oagi.app_oauth2_user.oauth2_app_id</code>. A reference
     * to the record in `oauth2_app`.
     */
    public final TableField<AppOauth2UserRecord, ULong> OAUTH2_APP_ID = createField(DSL.name("oauth2_app_id"), SQLDataType.BIGINTUNSIGNED.nullable(false), this, "A reference to the record in `oauth2_app`.");

    /**
     * The column <code>oagi.app_oauth2_user.sub</code>. `sub` claim defined in
     * OIDC spec. This is a unique identifier of the subject in the provider.
     */
    public final TableField<AppOauth2UserRecord, String> SUB = createField(DSL.name("sub"), SQLDataType.VARCHAR(100).nullable(false), this, "`sub` claim defined in OIDC spec. This is a unique identifier of the subject in the provider.");

    /**
     * The column <code>oagi.app_oauth2_user.name</code>. `name` claim defined
     * in OIDC spec.
     */
    public final TableField<AppOauth2UserRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(200), this, "`name` claim defined in OIDC spec.");

    /**
     * The column <code>oagi.app_oauth2_user.email</code>. `email` claim defined
     * in OIDC spec.
     */
    public final TableField<AppOauth2UserRecord, String> EMAIL = createField(DSL.name("email"), SQLDataType.VARCHAR(200), this, "`email` claim defined in OIDC spec.");

    /**
     * The column <code>oagi.app_oauth2_user.nickname</code>. `nickname` claim
     * defined in OIDC spec.
     */
    public final TableField<AppOauth2UserRecord, String> NICKNAME = createField(DSL.name("nickname"), SQLDataType.VARCHAR(200), this, "`nickname` claim defined in OIDC spec.");

    /**
     * The column <code>oagi.app_oauth2_user.preferred_username</code>.
     * `preferred_username` claim defined in OIDC spec.
     */
    public final TableField<AppOauth2UserRecord, String> PREFERRED_USERNAME = createField(DSL.name("preferred_username"), SQLDataType.VARCHAR(200), this, "`preferred_username` claim defined in OIDC spec.");

    /**
     * The column <code>oagi.app_oauth2_user.phone_number</code>. `phone_number`
     * claim defined in OIDC spec.
     */
    public final TableField<AppOauth2UserRecord, String> PHONE_NUMBER = createField(DSL.name("phone_number"), SQLDataType.VARCHAR(200), this, "`phone_number` claim defined in OIDC spec.");

    /**
     * The column <code>oagi.app_oauth2_user.creation_timestamp</code>.
     * Timestamp when this record is created.
     */
    public final TableField<AppOauth2UserRecord, LocalDateTime> CREATION_TIMESTAMP = createField(DSL.name("creation_timestamp"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "Timestamp when this record is created.");

    private AppOauth2User(Name alias, Table<AppOauth2UserRecord> aliased) {
        this(alias, aliased, null);
    }

    private AppOauth2User(Name alias, Table<AppOauth2UserRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>oagi.app_oauth2_user</code> table reference
     */
    public AppOauth2User(String alias) {
        this(DSL.name(alias), APP_OAUTH2_USER);
    }

    /**
     * Create an aliased <code>oagi.app_oauth2_user</code> table reference
     */
    public AppOauth2User(Name alias) {
        this(alias, APP_OAUTH2_USER);
    }

    /**
     * Create a <code>oagi.app_oauth2_user</code> table reference
     */
    public AppOauth2User() {
        this(DSL.name("app_oauth2_user"), null);
    }

    public <O extends Record> AppOauth2User(Table<O> child, ForeignKey<O, AppOauth2UserRecord> key) {
        super(child, key, APP_OAUTH2_USER);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Oagi.OAGI;
    }

    @Override
    public Identity<AppOauth2UserRecord, ULong> getIdentity() {
        return (Identity<AppOauth2UserRecord, ULong>) super.getIdentity();
    }

    @Override
    public UniqueKey<AppOauth2UserRecord> getPrimaryKey() {
        return Keys.KEY_APP_OAUTH2_USER_PRIMARY;
    }

    @Override
    public List<UniqueKey<AppOauth2UserRecord>> getUniqueKeys() {
        return Arrays.asList(Keys.KEY_APP_OAUTH2_USER_APP_OAUTH2_USER_UK1);
    }

    @Override
    public List<ForeignKey<AppOauth2UserRecord, ?>> getReferences() {
        return Arrays.asList(Keys.APP_OAUTH2_USER_APP_USER_ID_FK, Keys.APP_OAUTH2_USER_OAUTH2_APP_ID_FK);
    }

    private transient AppUser _appUser;
    private transient Oauth2App _oauth2App;

    /**
     * Get the implicit join path to the <code>oagi.app_user</code> table.
     */
    public AppUser appUser() {
        if (_appUser == null)
            _appUser = new AppUser(this, Keys.APP_OAUTH2_USER_APP_USER_ID_FK);

        return _appUser;
    }

    /**
     * Get the implicit join path to the <code>oagi.oauth2_app</code> table.
     */
    public Oauth2App oauth2App() {
        if (_oauth2App == null)
            _oauth2App = new Oauth2App(this, Keys.APP_OAUTH2_USER_OAUTH2_APP_ID_FK);

        return _oauth2App;
    }

    @Override
    public AppOauth2User as(String alias) {
        return new AppOauth2User(DSL.name(alias), this);
    }

    @Override
    public AppOauth2User as(Name alias) {
        return new AppOauth2User(alias, this);
    }

    @Override
    public AppOauth2User as(Table<?> alias) {
        return new AppOauth2User(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public AppOauth2User rename(String name) {
        return new AppOauth2User(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public AppOauth2User rename(Name name) {
        return new AppOauth2User(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public AppOauth2User rename(Table<?> name) {
        return new AppOauth2User(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row10 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row10<ULong, ULong, ULong, String, String, String, String, String, String, LocalDateTime> fieldsRow() {
        return (Row10) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function10<? super ULong, ? super ULong, ? super ULong, ? super String, ? super String, ? super String, ? super String, ? super String, ? super String, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function10<? super ULong, ? super ULong, ? super ULong, ? super String, ? super String, ? super String, ? super String, ? super String, ? super String, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
