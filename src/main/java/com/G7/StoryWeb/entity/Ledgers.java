package com.G7.StoryWeb.entity;

import javax.persistence.*;

@Entity(name = "ledger")
public class Ledgers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "amount")
    private int amount;

    @Column(name = "date_ledger")
    private long dateLedger;

    @Column(name = "description")
    private String desc;

    @ManyToOne
    @JoinColumn(name = "inbound_account_id")
    private Users inboundAccount;

    @ManyToOne
    @JoinColumn(name = "outbound_account_id")
    private Users outboundAccount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public long getDateLedger() {
        return dateLedger;
    }

    public void setDateLedger(long dateLedger) {
        this.dateLedger = dateLedger;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Users getInboundAccount() {
        return inboundAccount;
    }

    public void setInboundAccount(Users inboundAccount) {
        this.inboundAccount = inboundAccount;
    }

    public Users getOutboundAccount() {
        return outboundAccount;
    }

    public void setOutboundAccount(Users outboundAccount) {
        this.outboundAccount = outboundAccount;
    }
}
