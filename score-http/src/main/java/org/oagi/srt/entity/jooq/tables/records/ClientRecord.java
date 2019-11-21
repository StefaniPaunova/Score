/*
 * This file is generated by jOOQ.
 */
package org.oagi.srt.entity.jooq.tables.records;


import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;
import org.jooq.types.ULong;
import org.oagi.srt.entity.jooq.tables.Client;


/**
 * This table captures a client organization. It is used, for example, to 
 * indicate the customer, for which the BIE was generated.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ClientRecord extends UpdatableRecordImpl<ClientRecord> implements Record2<ULong, String> {

    private static final long serialVersionUID = -1386962223;

    /**
     * Setter for <code>oagi.client.client_id</code>. Primary, internal database key.
     */
    public void setClientId(ULong value) {
        set(0, value);
    }

    /**
     * Getter for <code>oagi.client.client_id</code>. Primary, internal database key.
     */
    public ULong getClientId() {
        return (ULong) get(0);
    }

    /**
     * Setter for <code>oagi.client.name</code>. Pretty print name of the client.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>oagi.client.name</code>. Pretty print name of the client.
     */
    public String getName() {
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
        return Client.CLIENT.CLIENT_ID;
    }

    @Override
    public Field<String> field2() {
        return Client.CLIENT.NAME;
    }

    @Override
    public ULong component1() {
        return getClientId();
    }

    @Override
    public String component2() {
        return getName();
    }

    @Override
    public ULong value1() {
        return getClientId();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public ClientRecord value1(ULong value) {
        setClientId(value);
        return this;
    }

    @Override
    public ClientRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public ClientRecord values(ULong value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ClientRecord
     */
    public ClientRecord() {
        super(Client.CLIENT);
    }

    /**
     * Create a detached, initialised ClientRecord
     */
    public ClientRecord(ULong clientId, String name) {
        super(Client.CLIENT);

        set(0, clientId);
        set(1, name);
    }
}
