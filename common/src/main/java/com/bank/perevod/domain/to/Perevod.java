package com.bank.perevod.domain.to;

import java.sql.Time;
import java.util.Date;
import java.util.Objects;

public class Perevod {
        private Long idPerevod;
        private Long idClient;
        private Long idBank;
        private Long idCard1;
        private Long idCard2;
        private String typeCard1;
        private String typeCard2;
        private Date srokCard;
        private String securityCode;
        private Long idAccount;
        private double summa;
        private String valuta;
        private double stavka;
        private double komisiya;
        private Date datePerevoda;
        private Time timePerevoda;

    public Perevod() {
    }

    public Perevod(Long idPerevod, Long idClient,
                   Long idBank, Long idCard1, Long idCard2,
                   String typeCard1, String typeCard2, String securityCode,
                   Long idAccount, double summa, String valuta) {
        this.idPerevod = idPerevod;
        this.idClient = idClient;
        this.idBank = idBank;
        this.idCard1 = idCard1;
        this.idCard2 = idCard2;
        this.typeCard1 = typeCard1;
        this.typeCard2 = typeCard2;
        this.securityCode = securityCode;
        this.idAccount = idAccount;
        this.summa = summa;
        this.valuta = valuta;
    }

    public Perevod(Long idPerevod, Long idClient, Long idBank, Long idCard1, Long idCard2,
                   String typeCard1, String typeCard2, Date srokCard, String securityCode,
                   Long idAccount, double summa, String valuta, double stavka, double komisiya,
                   Date datePerevoda, Time timePerevoda) {
        this.idPerevod = idPerevod;
        this.idClient = idClient;
        this.idBank = idBank;
        this.idCard1 = idCard1;
        this.idCard2 = idCard2;
        this.typeCard1 = typeCard1;
        this.typeCard2 = typeCard2;
        this.srokCard = srokCard;
        this.securityCode = securityCode;
        this.idAccount = idAccount;
        this.summa = summa;
        this.valuta = valuta;
        this.stavka = stavka;
        this.komisiya = komisiya;
        this.datePerevoda = datePerevoda;
        this.timePerevoda = timePerevoda;
    }

    public Long getIdPerevod() {
        return idPerevod;
    }

    public void setIdPerevod(Long idPerevod) {
        this.idPerevod = idPerevod;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public Long getIdBank() {
        return idBank;
    }

    public void setIdBank(Long idBank) {
        this.idBank = idBank;
    }

    public Long getIdCard1() {
        return idCard1;
    }

    public void setIdCard1(Long idCard1) {
        this.idCard1 = idCard1;
    }

    public Long getIdCard2() {
        return idCard2;
    }

    public void setIdCard2(Long idCard2) {
        this.idCard2 = idCard2;
    }

    public String getTypeCard1() {
        return typeCard1;
    }

    public void setTypeCard1(String typeCard1) {
        this.typeCard1 = typeCard1;
    }

    public String getTypeCard2() {
        return typeCard2;
    }

    public void setTypeCard2(String typeCard2) {
        this.typeCard2 = typeCard2;
    }

    public Date getSrokCard() {
        return srokCard;
    }

    public void setSrokCard(Date srokCard) {
        this.srokCard = srokCard;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public Long getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Long idAccount) {
        this.idAccount = idAccount;
    }

    public double getSumma() {
        return summa;
    }

    public void setSumma(double summa) {
        this.summa = summa;
    }

    public String getValuta() {
        return valuta;
    }

    public void setValuta(String valuta) {
        this.valuta = valuta;
    }

    public double getStavka() {
        return stavka;
    }

    public void setStavka(double stavka) {
        this.stavka = stavka;
    }

    public double getKomisiya() {
        return komisiya;
    }

    public void setKomisiya(double komisiya) {
        this.komisiya = komisiya;
    }

    public Date getDatePerevoda() {
        return datePerevoda;
    }

    public void setDatePerevoda(Date datePerevoda) {
        this.datePerevoda = datePerevoda;
    }

    public Time getTimePerevoda() {
        return timePerevoda;
    }

    public void setTimePerevoda(Time timePerevoda) {
        this.timePerevoda = timePerevoda;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Perevod perevod = (Perevod) o;
        return Double.compare(perevod.summa, summa) == 0 &&
                Double.compare(perevod.stavka, stavka) == 0 &&
                Double.compare(perevod.komisiya, komisiya) == 0 &&
                idPerevod.equals(perevod.idPerevod) &&
                idClient.equals(perevod.idClient) &&
                idBank.equals(perevod.idBank) &&
                idCard1.equals(perevod.idCard1) &&
                idCard2.equals(perevod.idCard2) &&
                typeCard1.equals(perevod.typeCard1) &&
                typeCard2.equals(perevod.typeCard2) &&
                srokCard.equals(perevod.srokCard) &&
                securityCode.equals(perevod.securityCode) &&
                idAccount.equals(perevod.idAccount) &&
                valuta.equals(perevod.valuta) &&
                datePerevoda.equals(perevod.datePerevoda) &&
                timePerevoda.equals(perevod.timePerevoda);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPerevod, idClient, idBank, idCard1, idCard2, typeCard1, typeCard2, srokCard, securityCode, idAccount, summa, valuta, stavka, komisiya, datePerevoda, timePerevoda);
    }

    @Override
    public String toString() {
        return "Perevod{" +
                "idPerevod=" + idPerevod +
                ", idClient=" + idClient +
                ", idBank=" + idBank +
                ", idCard1=" + idCard1 +
                ", idCard2=" + idCard2 +
                ", typeCard1='" + typeCard1 + '\'' +
                ", typeCard2='" + typeCard2 + '\'' +
                ", srokCard=" + srokCard +
                ", securityCode='" + securityCode + '\'' +
                ", idAccount=" + idAccount +
                ", summa=" + summa +
                ", valuta='" + valuta + '\'' +
                ", stavka=" + stavka +
                ", komisiya=" + komisiya +
                ", datePerevoda=" + datePerevoda +
                ", timePerevoda=" + timePerevoda +
                '}';
    }
}
