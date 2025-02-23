/*
 * This file is generated by jOOQ.
 */
package org.oagi.score.repo.api.impl.jooq.entity.tables.records;


import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record22;
import org.jooq.Row22;
import org.jooq.impl.UpdatableRecordImpl;
import org.jooq.types.ULong;
import org.oagi.score.repo.api.impl.jooq.entity.tables.CodeList;


/**
 * This table stores information about a code list. When a code list is derived
 * from another code list, the whole set of code values belonging to the based
 * code list will be copied.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CodeListRecord extends UpdatableRecordImpl<CodeListRecord> implements Record22<ULong, String, String, String, String, String, String, String, String, ULong, ULong, Byte, Byte, ULong, ULong, ULong, ULong, LocalDateTime, LocalDateTime, String, ULong, ULong> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>oagi.code_list.code_list_id</code>. Internal, primary
     * database key.
     */
    public void setCodeListId(ULong value) {
        set(0, value);
    }

    /**
     * Getter for <code>oagi.code_list.code_list_id</code>. Internal, primary
     * database key.
     */
    public ULong getCodeListId() {
        return (ULong) get(0);
    }

    /**
     * Setter for <code>oagi.code_list.guid</code>. A globally unique identifier
     * (GUID).
     */
    public void setGuid(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>oagi.code_list.guid</code>. A globally unique identifier
     * (GUID).
     */
    public String getGuid() {
        return (String) get(1);
    }

    /**
     * Setter for <code>oagi.code_list.enum_type_guid</code>. In the OAGIS Model
     * XML schema, a type, which keeps all the enumerated values, is  defined
     * separately from the type that represents a code list. This only applies
     * to some code lists. When that is the case, this column stores the GUID of
     * that enumeration type.
     */
    public void setEnumTypeGuid(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>oagi.code_list.enum_type_guid</code>. In the OAGIS Model
     * XML schema, a type, which keeps all the enumerated values, is  defined
     * separately from the type that represents a code list. This only applies
     * to some code lists. When that is the case, this column stores the GUID of
     * that enumeration type.
     */
    public String getEnumTypeGuid() {
        return (String) get(2);
    }

    /**
     * Setter for <code>oagi.code_list.name</code>. Name of the code list.
     */
    public void setName(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>oagi.code_list.name</code>. Name of the code list.
     */
    public String getName() {
        return (String) get(3);
    }

    /**
     * Setter for <code>oagi.code_list.list_id</code>. External identifier.
     */
    public void setListId(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>oagi.code_list.list_id</code>. External identifier.
     */
    public String getListId() {
        return (String) get(4);
    }

    /**
     * Setter for <code>oagi.code_list.version_id</code>. Code list version
     * number.
     */
    public void setVersionId(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>oagi.code_list.version_id</code>. Code list version
     * number.
     */
    public String getVersionId() {
        return (String) get(5);
    }

    /**
     * Setter for <code>oagi.code_list.definition</code>. Description of the
     * code list.
     */
    public void setDefinition(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>oagi.code_list.definition</code>. Description of the
     * code list.
     */
    public String getDefinition() {
        return (String) get(6);
    }

    /**
     * Setter for <code>oagi.code_list.remark</code>. Usage information about
     * the code list.
     */
    public void setRemark(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>oagi.code_list.remark</code>. Usage information about
     * the code list.
     */
    public String getRemark() {
        return (String) get(7);
    }

    /**
     * Setter for <code>oagi.code_list.definition_source</code>. This is
     * typically a URL which indicates the source of the code list's DEFINITION.
     */
    public void setDefinitionSource(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>oagi.code_list.definition_source</code>. This is
     * typically a URL which indicates the source of the code list's DEFINITION.
     */
    public String getDefinitionSource() {
        return (String) get(8);
    }

    /**
     * Setter for <code>oagi.code_list.namespace_id</code>. Foreign key to the
     * NAMESPACE table. This is the namespace to which the entity belongs. This
     * namespace column is primarily used in the case the component is a user's
     * component because there is also a namespace assigned at the release
     * level.
     */
    public void setNamespaceId(ULong value) {
        set(9, value);
    }

    /**
     * Getter for <code>oagi.code_list.namespace_id</code>. Foreign key to the
     * NAMESPACE table. This is the namespace to which the entity belongs. This
     * namespace column is primarily used in the case the component is a user's
     * component because there is also a namespace assigned at the release
     * level.
     */
    public ULong getNamespaceId() {
        return (ULong) get(9);
    }

    /**
     * Setter for <code>oagi.code_list.based_code_list_id</code>. This is a
     * foreign key to the CODE_LIST table itself. This identifies the code list
     * on which this code list is based, if any. The derivation may be
     * restriction and/or extension.
     */
    public void setBasedCodeListId(ULong value) {
        set(10, value);
    }

    /**
     * Getter for <code>oagi.code_list.based_code_list_id</code>. This is a
     * foreign key to the CODE_LIST table itself. This identifies the code list
     * on which this code list is based, if any. The derivation may be
     * restriction and/or extension.
     */
    public ULong getBasedCodeListId() {
        return (ULong) get(10);
    }

    /**
     * Setter for <code>oagi.code_list.extensible_indicator</code>. This is a
     * flag to indicate whether the code list is final and shall not be further
     * derived.
     */
    public void setExtensibleIndicator(Byte value) {
        set(11, value);
    }

    /**
     * Getter for <code>oagi.code_list.extensible_indicator</code>. This is a
     * flag to indicate whether the code list is final and shall not be further
     * derived.
     */
    public Byte getExtensibleIndicator() {
        return (Byte) get(11);
    }

    /**
     * Setter for <code>oagi.code_list.is_deprecated</code>. Indicates whether
     * the code list is deprecated and should not be reused (i.e., no new
     * reference to this record should be allowed).
     */
    public void setIsDeprecated(Byte value) {
        set(12, value);
    }

    /**
     * Getter for <code>oagi.code_list.is_deprecated</code>. Indicates whether
     * the code list is deprecated and should not be reused (i.e., no new
     * reference to this record should be allowed).
     */
    public Byte getIsDeprecated() {
        return (Byte) get(12);
    }

    /**
     * Setter for <code>oagi.code_list.replacement_code_list_id</code>. This
     * refers to a replacement if the record is deprecated.
     */
    public void setReplacementCodeListId(ULong value) {
        set(13, value);
    }

    /**
     * Getter for <code>oagi.code_list.replacement_code_list_id</code>. This
     * refers to a replacement if the record is deprecated.
     */
    public ULong getReplacementCodeListId() {
        return (ULong) get(13);
    }

    /**
     * Setter for <code>oagi.code_list.created_by</code>. Foreign key to the
     * APP_USER table. It indicates the user who created the code list.
     */
    public void setCreatedBy(ULong value) {
        set(14, value);
    }

    /**
     * Getter for <code>oagi.code_list.created_by</code>. Foreign key to the
     * APP_USER table. It indicates the user who created the code list.
     */
    public ULong getCreatedBy() {
        return (ULong) get(14);
    }

    /**
     * Setter for <code>oagi.code_list.owner_user_id</code>. Foreign key to the
     * APP_USER table. This is the user who owns the entity, is allowed to edit
     * the entity, and who can transfer the ownership to another user.
     * 
     * The ownership can change throughout the history, but undoing shouldn't
     * rollback the ownership.
     */
    public void setOwnerUserId(ULong value) {
        set(15, value);
    }

    /**
     * Getter for <code>oagi.code_list.owner_user_id</code>. Foreign key to the
     * APP_USER table. This is the user who owns the entity, is allowed to edit
     * the entity, and who can transfer the ownership to another user.
     * 
     * The ownership can change throughout the history, but undoing shouldn't
     * rollback the ownership.
     */
    public ULong getOwnerUserId() {
        return (ULong) get(15);
    }

    /**
     * Setter for <code>oagi.code_list.last_updated_by</code>. Foreign key to
     * the APP_USER table. It identifies the user who last updated the code
     * list.
     */
    public void setLastUpdatedBy(ULong value) {
        set(16, value);
    }

    /**
     * Getter for <code>oagi.code_list.last_updated_by</code>. Foreign key to
     * the APP_USER table. It identifies the user who last updated the code
     * list.
     */
    public ULong getLastUpdatedBy() {
        return (ULong) get(16);
    }

    /**
     * Setter for <code>oagi.code_list.creation_timestamp</code>. Timestamp when
     * the code list was created.
     */
    public void setCreationTimestamp(LocalDateTime value) {
        set(17, value);
    }

    /**
     * Getter for <code>oagi.code_list.creation_timestamp</code>. Timestamp when
     * the code list was created.
     */
    public LocalDateTime getCreationTimestamp() {
        return (LocalDateTime) get(17);
    }

    /**
     * Setter for <code>oagi.code_list.last_update_timestamp</code>. Timestamp
     * when the code list was last updated.
     */
    public void setLastUpdateTimestamp(LocalDateTime value) {
        set(18, value);
    }

    /**
     * Getter for <code>oagi.code_list.last_update_timestamp</code>. Timestamp
     * when the code list was last updated.
     */
    public LocalDateTime getLastUpdateTimestamp() {
        return (LocalDateTime) get(18);
    }

    /**
     * Setter for <code>oagi.code_list.state</code>.
     */
    public void setState(String value) {
        set(19, value);
    }

    /**
     * Getter for <code>oagi.code_list.state</code>.
     */
    public String getState() {
        return (String) get(19);
    }

    /**
     * Setter for <code>oagi.code_list.prev_code_list_id</code>. A self-foreign
     * key to indicate the previous history record.
     */
    public void setPrevCodeListId(ULong value) {
        set(20, value);
    }

    /**
     * Getter for <code>oagi.code_list.prev_code_list_id</code>. A self-foreign
     * key to indicate the previous history record.
     */
    public ULong getPrevCodeListId() {
        return (ULong) get(20);
    }

    /**
     * Setter for <code>oagi.code_list.next_code_list_id</code>. A self-foreign
     * key to indicate the next history record.
     */
    public void setNextCodeListId(ULong value) {
        set(21, value);
    }

    /**
     * Getter for <code>oagi.code_list.next_code_list_id</code>. A self-foreign
     * key to indicate the next history record.
     */
    public ULong getNextCodeListId() {
        return (ULong) get(21);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<ULong> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record22 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row22<ULong, String, String, String, String, String, String, String, String, ULong, ULong, Byte, Byte, ULong, ULong, ULong, ULong, LocalDateTime, LocalDateTime, String, ULong, ULong> fieldsRow() {
        return (Row22) super.fieldsRow();
    }

    @Override
    public Row22<ULong, String, String, String, String, String, String, String, String, ULong, ULong, Byte, Byte, ULong, ULong, ULong, ULong, LocalDateTime, LocalDateTime, String, ULong, ULong> valuesRow() {
        return (Row22) super.valuesRow();
    }

    @Override
    public Field<ULong> field1() {
        return CodeList.CODE_LIST.CODE_LIST_ID;
    }

    @Override
    public Field<String> field2() {
        return CodeList.CODE_LIST.GUID;
    }

    @Override
    public Field<String> field3() {
        return CodeList.CODE_LIST.ENUM_TYPE_GUID;
    }

    @Override
    public Field<String> field4() {
        return CodeList.CODE_LIST.NAME;
    }

    @Override
    public Field<String> field5() {
        return CodeList.CODE_LIST.LIST_ID;
    }

    @Override
    public Field<String> field6() {
        return CodeList.CODE_LIST.VERSION_ID;
    }

    @Override
    public Field<String> field7() {
        return CodeList.CODE_LIST.DEFINITION;
    }

    @Override
    public Field<String> field8() {
        return CodeList.CODE_LIST.REMARK;
    }

    @Override
    public Field<String> field9() {
        return CodeList.CODE_LIST.DEFINITION_SOURCE;
    }

    @Override
    public Field<ULong> field10() {
        return CodeList.CODE_LIST.NAMESPACE_ID;
    }

    @Override
    public Field<ULong> field11() {
        return CodeList.CODE_LIST.BASED_CODE_LIST_ID;
    }

    @Override
    public Field<Byte> field12() {
        return CodeList.CODE_LIST.EXTENSIBLE_INDICATOR;
    }

    @Override
    public Field<Byte> field13() {
        return CodeList.CODE_LIST.IS_DEPRECATED;
    }

    @Override
    public Field<ULong> field14() {
        return CodeList.CODE_LIST.REPLACEMENT_CODE_LIST_ID;
    }

    @Override
    public Field<ULong> field15() {
        return CodeList.CODE_LIST.CREATED_BY;
    }

    @Override
    public Field<ULong> field16() {
        return CodeList.CODE_LIST.OWNER_USER_ID;
    }

    @Override
    public Field<ULong> field17() {
        return CodeList.CODE_LIST.LAST_UPDATED_BY;
    }

    @Override
    public Field<LocalDateTime> field18() {
        return CodeList.CODE_LIST.CREATION_TIMESTAMP;
    }

    @Override
    public Field<LocalDateTime> field19() {
        return CodeList.CODE_LIST.LAST_UPDATE_TIMESTAMP;
    }

    @Override
    public Field<String> field20() {
        return CodeList.CODE_LIST.STATE;
    }

    @Override
    public Field<ULong> field21() {
        return CodeList.CODE_LIST.PREV_CODE_LIST_ID;
    }

    @Override
    public Field<ULong> field22() {
        return CodeList.CODE_LIST.NEXT_CODE_LIST_ID;
    }

    @Override
    public ULong component1() {
        return getCodeListId();
    }

    @Override
    public String component2() {
        return getGuid();
    }

    @Override
    public String component3() {
        return getEnumTypeGuid();
    }

    @Override
    public String component4() {
        return getName();
    }

    @Override
    public String component5() {
        return getListId();
    }

    @Override
    public String component6() {
        return getVersionId();
    }

    @Override
    public String component7() {
        return getDefinition();
    }

    @Override
    public String component8() {
        return getRemark();
    }

    @Override
    public String component9() {
        return getDefinitionSource();
    }

    @Override
    public ULong component10() {
        return getNamespaceId();
    }

    @Override
    public ULong component11() {
        return getBasedCodeListId();
    }

    @Override
    public Byte component12() {
        return getExtensibleIndicator();
    }

    @Override
    public Byte component13() {
        return getIsDeprecated();
    }

    @Override
    public ULong component14() {
        return getReplacementCodeListId();
    }

    @Override
    public ULong component15() {
        return getCreatedBy();
    }

    @Override
    public ULong component16() {
        return getOwnerUserId();
    }

    @Override
    public ULong component17() {
        return getLastUpdatedBy();
    }

    @Override
    public LocalDateTime component18() {
        return getCreationTimestamp();
    }

    @Override
    public LocalDateTime component19() {
        return getLastUpdateTimestamp();
    }

    @Override
    public String component20() {
        return getState();
    }

    @Override
    public ULong component21() {
        return getPrevCodeListId();
    }

    @Override
    public ULong component22() {
        return getNextCodeListId();
    }

    @Override
    public ULong value1() {
        return getCodeListId();
    }

    @Override
    public String value2() {
        return getGuid();
    }

    @Override
    public String value3() {
        return getEnumTypeGuid();
    }

    @Override
    public String value4() {
        return getName();
    }

    @Override
    public String value5() {
        return getListId();
    }

    @Override
    public String value6() {
        return getVersionId();
    }

    @Override
    public String value7() {
        return getDefinition();
    }

    @Override
    public String value8() {
        return getRemark();
    }

    @Override
    public String value9() {
        return getDefinitionSource();
    }

    @Override
    public ULong value10() {
        return getNamespaceId();
    }

    @Override
    public ULong value11() {
        return getBasedCodeListId();
    }

    @Override
    public Byte value12() {
        return getExtensibleIndicator();
    }

    @Override
    public Byte value13() {
        return getIsDeprecated();
    }

    @Override
    public ULong value14() {
        return getReplacementCodeListId();
    }

    @Override
    public ULong value15() {
        return getCreatedBy();
    }

    @Override
    public ULong value16() {
        return getOwnerUserId();
    }

    @Override
    public ULong value17() {
        return getLastUpdatedBy();
    }

    @Override
    public LocalDateTime value18() {
        return getCreationTimestamp();
    }

    @Override
    public LocalDateTime value19() {
        return getLastUpdateTimestamp();
    }

    @Override
    public String value20() {
        return getState();
    }

    @Override
    public ULong value21() {
        return getPrevCodeListId();
    }

    @Override
    public ULong value22() {
        return getNextCodeListId();
    }

    @Override
    public CodeListRecord value1(ULong value) {
        setCodeListId(value);
        return this;
    }

    @Override
    public CodeListRecord value2(String value) {
        setGuid(value);
        return this;
    }

    @Override
    public CodeListRecord value3(String value) {
        setEnumTypeGuid(value);
        return this;
    }

    @Override
    public CodeListRecord value4(String value) {
        setName(value);
        return this;
    }

    @Override
    public CodeListRecord value5(String value) {
        setListId(value);
        return this;
    }

    @Override
    public CodeListRecord value6(String value) {
        setVersionId(value);
        return this;
    }

    @Override
    public CodeListRecord value7(String value) {
        setDefinition(value);
        return this;
    }

    @Override
    public CodeListRecord value8(String value) {
        setRemark(value);
        return this;
    }

    @Override
    public CodeListRecord value9(String value) {
        setDefinitionSource(value);
        return this;
    }

    @Override
    public CodeListRecord value10(ULong value) {
        setNamespaceId(value);
        return this;
    }

    @Override
    public CodeListRecord value11(ULong value) {
        setBasedCodeListId(value);
        return this;
    }

    @Override
    public CodeListRecord value12(Byte value) {
        setExtensibleIndicator(value);
        return this;
    }

    @Override
    public CodeListRecord value13(Byte value) {
        setIsDeprecated(value);
        return this;
    }

    @Override
    public CodeListRecord value14(ULong value) {
        setReplacementCodeListId(value);
        return this;
    }

    @Override
    public CodeListRecord value15(ULong value) {
        setCreatedBy(value);
        return this;
    }

    @Override
    public CodeListRecord value16(ULong value) {
        setOwnerUserId(value);
        return this;
    }

    @Override
    public CodeListRecord value17(ULong value) {
        setLastUpdatedBy(value);
        return this;
    }

    @Override
    public CodeListRecord value18(LocalDateTime value) {
        setCreationTimestamp(value);
        return this;
    }

    @Override
    public CodeListRecord value19(LocalDateTime value) {
        setLastUpdateTimestamp(value);
        return this;
    }

    @Override
    public CodeListRecord value20(String value) {
        setState(value);
        return this;
    }

    @Override
    public CodeListRecord value21(ULong value) {
        setPrevCodeListId(value);
        return this;
    }

    @Override
    public CodeListRecord value22(ULong value) {
        setNextCodeListId(value);
        return this;
    }

    @Override
    public CodeListRecord values(ULong value1, String value2, String value3, String value4, String value5, String value6, String value7, String value8, String value9, ULong value10, ULong value11, Byte value12, Byte value13, ULong value14, ULong value15, ULong value16, ULong value17, LocalDateTime value18, LocalDateTime value19, String value20, ULong value21, ULong value22) {
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
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        value15(value15);
        value16(value16);
        value17(value17);
        value18(value18);
        value19(value19);
        value20(value20);
        value21(value21);
        value22(value22);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CodeListRecord
     */
    public CodeListRecord() {
        super(CodeList.CODE_LIST);
    }

    /**
     * Create a detached, initialised CodeListRecord
     */
    public CodeListRecord(ULong codeListId, String guid, String enumTypeGuid, String name, String listId, String versionId, String definition, String remark, String definitionSource, ULong namespaceId, ULong basedCodeListId, Byte extensibleIndicator, Byte isDeprecated, ULong replacementCodeListId, ULong createdBy, ULong ownerUserId, ULong lastUpdatedBy, LocalDateTime creationTimestamp, LocalDateTime lastUpdateTimestamp, String state, ULong prevCodeListId, ULong nextCodeListId) {
        super(CodeList.CODE_LIST);

        setCodeListId(codeListId);
        setGuid(guid);
        setEnumTypeGuid(enumTypeGuid);
        setName(name);
        setListId(listId);
        setVersionId(versionId);
        setDefinition(definition);
        setRemark(remark);
        setDefinitionSource(definitionSource);
        setNamespaceId(namespaceId);
        setBasedCodeListId(basedCodeListId);
        setExtensibleIndicator(extensibleIndicator);
        setIsDeprecated(isDeprecated);
        setReplacementCodeListId(replacementCodeListId);
        setCreatedBy(createdBy);
        setOwnerUserId(ownerUserId);
        setLastUpdatedBy(lastUpdatedBy);
        setCreationTimestamp(creationTimestamp);
        setLastUpdateTimestamp(lastUpdateTimestamp);
        setState(state);
        setPrevCodeListId(prevCodeListId);
        setNextCodeListId(nextCodeListId);
    }
}
