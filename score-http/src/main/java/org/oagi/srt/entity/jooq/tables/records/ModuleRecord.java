/*
 * This file is generated by jOOQ.
 */
package org.oagi.srt.entity.jooq.tables.records;


import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record10;
import org.jooq.Row10;
import org.jooq.impl.UpdatableRecordImpl;
import org.jooq.types.ULong;
import org.oagi.srt.entity.jooq.tables.Module;


/**
 * The module table stores information about a physical file, into which CC 
 * components will be generated during the expression generation.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ModuleRecord extends UpdatableRecordImpl<ModuleRecord> implements Record10<ULong, String, ULong, ULong, String, ULong, ULong, ULong, Timestamp, Timestamp> {

    private static final long serialVersionUID = 222600494;

    /**
     * Setter for <code>oagi.module.module_id</code>. Primary, internal database key.
     */
    public void setModuleId(ULong value) {
        set(0, value);
    }

    /**
     * Getter for <code>oagi.module.module_id</code>. Primary, internal database key.
     */
    public ULong getModuleId() {
        return (ULong) get(0);
    }

    /**
     * Setter for <code>oagi.module.module</code>. The is the subdirectory and filename. The format is Windows file path. The starting directory typically is the root folder of all the release content. For example, for OAGIS 10.1 Model, the root directory is Model. If the file shall be directly under the Model directory, then this column should be 'Model\filename' without the extension. If the file is under, say, Model\Platform\2_1\Common\Components directory, then the value of this column shall be 'Model\Platform\2_1\Common\Components\filenam'. The reason to not including the extension is that the extension maybe dependent on the expression. For XML schema, '.xsd' maybe added; or for JSON, '.json' maybe added as the file extension.
     */
    public void setModule(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>oagi.module.module</code>. The is the subdirectory and filename. The format is Windows file path. The starting directory typically is the root folder of all the release content. For example, for OAGIS 10.1 Model, the root directory is Model. If the file shall be directly under the Model directory, then this column should be 'Model\filename' without the extension. If the file is under, say, Model\Platform\2_1\Common\Components directory, then the value of this column shall be 'Model\Platform\2_1\Common\Components\filenam'. The reason to not including the extension is that the extension maybe dependent on the expression. For XML schema, '.xsd' maybe added; or for JSON, '.json' maybe added as the file extension.
     */
    public String getModule() {
        return (String) get(1);
    }

    /**
     * Setter for <code>oagi.module.release_id</code>. Foreign key to the RELEASE table. It identifies the release, for which this module is associated.
     */
    public void setReleaseId(ULong value) {
        set(2, value);
    }

    /**
     * Getter for <code>oagi.module.release_id</code>. Foreign key to the RELEASE table. It identifies the release, for which this module is associated.
     */
    public ULong getReleaseId() {
        return (ULong) get(2);
    }

    /**
     * Setter for <code>oagi.module.namespace_id</code>. Note that a release record has a namespace associated. The NAMESPACE_ID, if specified here, overrides the release's namespace. However, the NAMESPACE_ID associated with the component takes the highest precedence.
     */
    public void setNamespaceId(ULong value) {
        set(3, value);
    }

    /**
     * Getter for <code>oagi.module.namespace_id</code>. Note that a release record has a namespace associated. The NAMESPACE_ID, if specified here, overrides the release's namespace. However, the NAMESPACE_ID associated with the component takes the highest precedence.
     */
    public ULong getNamespaceId() {
        return (ULong) get(3);
    }

    /**
     * Setter for <code>oagi.module.version_num</code>. This is the version number to be assigned to the schema module.
     */
    public void setVersionNum(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>oagi.module.version_num</code>. This is the version number to be assigned to the schema module.
     */
    public String getVersionNum() {
        return (String) get(4);
    }

    /**
     * Setter for <code>oagi.module.created_by</code>. Foreign key to the APP_USER table. It indicates the user who created this MODULE.
     */
    public void setCreatedBy(ULong value) {
        set(5, value);
    }

    /**
     * Getter for <code>oagi.module.created_by</code>. Foreign key to the APP_USER table. It indicates the user who created this MODULE.
     */
    public ULong getCreatedBy() {
        return (ULong) get(5);
    }

    /**
     * Setter for <code>oagi.module.last_updated_by</code>. Foreign key to the APP_USER table referring to the last user who updated the record. 

In the history record, this should always be the user who is editing the entity (perhaps except when the ownership has just been changed).
     */
    public void setLastUpdatedBy(ULong value) {
        set(6, value);
    }

    /**
     * Getter for <code>oagi.module.last_updated_by</code>. Foreign key to the APP_USER table referring to the last user who updated the record. 

In the history record, this should always be the user who is editing the entity (perhaps except when the ownership has just been changed).
     */
    public ULong getLastUpdatedBy() {
        return (ULong) get(6);
    }

    /**
     * Setter for <code>oagi.module.owner_user_id</code>. Foreign key to the APP_USER table identifying the user who can update or delete the record.
     */
    public void setOwnerUserId(ULong value) {
        set(7, value);
    }

    /**
     * Getter for <code>oagi.module.owner_user_id</code>. Foreign key to the APP_USER table identifying the user who can update or delete the record.
     */
    public ULong getOwnerUserId() {
        return (ULong) get(7);
    }

    /**
     * Setter for <code>oagi.module.creation_timestamp</code>. The timestamp when the record was first created.
     */
    public void setCreationTimestamp(Timestamp value) {
        set(8, value);
    }

    /**
     * Getter for <code>oagi.module.creation_timestamp</code>. The timestamp when the record was first created.
     */
    public Timestamp getCreationTimestamp() {
        return (Timestamp) get(8);
    }

    /**
     * Setter for <code>oagi.module.last_update_timestamp</code>. The timestamp when the record was last updated.
     */
    public void setLastUpdateTimestamp(Timestamp value) {
        set(9, value);
    }

    /**
     * Getter for <code>oagi.module.last_update_timestamp</code>. The timestamp when the record was last updated.
     */
    public Timestamp getLastUpdateTimestamp() {
        return (Timestamp) get(9);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<ULong> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record10 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row10<ULong, String, ULong, ULong, String, ULong, ULong, ULong, Timestamp, Timestamp> fieldsRow() {
        return (Row10) super.fieldsRow();
    }

    @Override
    public Row10<ULong, String, ULong, ULong, String, ULong, ULong, ULong, Timestamp, Timestamp> valuesRow() {
        return (Row10) super.valuesRow();
    }

    @Override
    public Field<ULong> field1() {
        return Module.MODULE.MODULE_ID;
    }

    @Override
    public Field<String> field2() {
        return Module.MODULE.MODULE_;
    }

    @Override
    public Field<ULong> field3() {
        return Module.MODULE.RELEASE_ID;
    }

    @Override
    public Field<ULong> field4() {
        return Module.MODULE.NAMESPACE_ID;
    }

    @Override
    public Field<String> field5() {
        return Module.MODULE.VERSION_NUM;
    }

    @Override
    public Field<ULong> field6() {
        return Module.MODULE.CREATED_BY;
    }

    @Override
    public Field<ULong> field7() {
        return Module.MODULE.LAST_UPDATED_BY;
    }

    @Override
    public Field<ULong> field8() {
        return Module.MODULE.OWNER_USER_ID;
    }

    @Override
    public Field<Timestamp> field9() {
        return Module.MODULE.CREATION_TIMESTAMP;
    }

    @Override
    public Field<Timestamp> field10() {
        return Module.MODULE.LAST_UPDATE_TIMESTAMP;
    }

    @Override
    public ULong component1() {
        return getModuleId();
    }

    @Override
    public String component2() {
        return getModule();
    }

    @Override
    public ULong component3() {
        return getReleaseId();
    }

    @Override
    public ULong component4() {
        return getNamespaceId();
    }

    @Override
    public String component5() {
        return getVersionNum();
    }

    @Override
    public ULong component6() {
        return getCreatedBy();
    }

    @Override
    public ULong component7() {
        return getLastUpdatedBy();
    }

    @Override
    public ULong component8() {
        return getOwnerUserId();
    }

    @Override
    public Timestamp component9() {
        return getCreationTimestamp();
    }

    @Override
    public Timestamp component10() {
        return getLastUpdateTimestamp();
    }

    @Override
    public ULong value1() {
        return getModuleId();
    }

    @Override
    public String value2() {
        return getModule();
    }

    @Override
    public ULong value3() {
        return getReleaseId();
    }

    @Override
    public ULong value4() {
        return getNamespaceId();
    }

    @Override
    public String value5() {
        return getVersionNum();
    }

    @Override
    public ULong value6() {
        return getCreatedBy();
    }

    @Override
    public ULong value7() {
        return getLastUpdatedBy();
    }

    @Override
    public ULong value8() {
        return getOwnerUserId();
    }

    @Override
    public Timestamp value9() {
        return getCreationTimestamp();
    }

    @Override
    public Timestamp value10() {
        return getLastUpdateTimestamp();
    }

    @Override
    public ModuleRecord value1(ULong value) {
        setModuleId(value);
        return this;
    }

    @Override
    public ModuleRecord value2(String value) {
        setModule(value);
        return this;
    }

    @Override
    public ModuleRecord value3(ULong value) {
        setReleaseId(value);
        return this;
    }

    @Override
    public ModuleRecord value4(ULong value) {
        setNamespaceId(value);
        return this;
    }

    @Override
    public ModuleRecord value5(String value) {
        setVersionNum(value);
        return this;
    }

    @Override
    public ModuleRecord value6(ULong value) {
        setCreatedBy(value);
        return this;
    }

    @Override
    public ModuleRecord value7(ULong value) {
        setLastUpdatedBy(value);
        return this;
    }

    @Override
    public ModuleRecord value8(ULong value) {
        setOwnerUserId(value);
        return this;
    }

    @Override
    public ModuleRecord value9(Timestamp value) {
        setCreationTimestamp(value);
        return this;
    }

    @Override
    public ModuleRecord value10(Timestamp value) {
        setLastUpdateTimestamp(value);
        return this;
    }

    @Override
    public ModuleRecord values(ULong value1, String value2, ULong value3, ULong value4, String value5, ULong value6, ULong value7, ULong value8, Timestamp value9, Timestamp value10) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ModuleRecord
     */
    public ModuleRecord() {
        super(Module.MODULE);
    }

    /**
     * Create a detached, initialised ModuleRecord
     */
    public ModuleRecord(ULong moduleId, String module, ULong releaseId, ULong namespaceId, String versionNum, ULong createdBy, ULong lastUpdatedBy, ULong ownerUserId, Timestamp creationTimestamp, Timestamp lastUpdateTimestamp) {
        super(Module.MODULE);

        set(0, moduleId);
        set(1, module);
        set(2, releaseId);
        set(3, namespaceId);
        set(4, versionNum);
        set(5, createdBy);
        set(6, lastUpdatedBy);
        set(7, ownerUserId);
        set(8, creationTimestamp);
        set(9, lastUpdateTimestamp);
    }
}
