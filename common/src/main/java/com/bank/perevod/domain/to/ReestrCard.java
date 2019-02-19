package com.bank.perevod.domain.to;

import java.util.Objects;

public class ReestrCard {
    private Long idCard;
    private Long idClient;
    private String numCard;
    private String srok;
    private String securityCode;
    private Long idAccount;
    private Long idBank;

    public ReestrCard() {
    }

    public ReestrCard(Long idCard, Long idClient, String numCard, Long idAccount, Long idBank) {
        this.idCard = idCard;
        this.idClient = idClient;
        this.numCard = numCard;
        this.idAccount = idAccount;
        this.idBank = idBank;
    }

    public ReestrCard(Long idCard, Long idClient, String numCard, String srok, String securityCode, Long idAccount, Long idBank) {
        this.idCard = idCard;
        this.idClient = idClient;
        this.numCard = numCard;
        this.srok = srok;
        this.securityCode = securityCode;
        this.idAccount = idAccount;
        this.idBank = idBank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReestrCard that = (ReestrCard) o;
        return idCard.equals(that.idCard) &&
                idClient.equals(that.idClient) &&
                numCard.equals(that.numCard) &&
                srok.equals(that.srok) &&
                securityCode.equals(that.securityCode) &&
                idAccount.equals(that.idAccount) &&
                idBank.equals(that.idBank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCard, idClient, numCard, srok, securityCode, idAccount, idBank);
    }

    @Override
    public String toString() {
        return "ReestrCard{" +
                "idCard=" + idCard +
                ", idClient=" + idClient +
                ", numCard='" + numCard + '\'' +
                ", srok='" + srok + '\'' +
                ", securityCode='" + securityCode + '\'' +
                ", idAccount=" + idAccount +
                ", idBank=" + idBank +
                '}';
    }
}
