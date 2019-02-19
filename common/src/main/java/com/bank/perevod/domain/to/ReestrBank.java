package com.bank.perevod.domain.to;

import java.util.Objects;

public class ReestrBank {
    private Long idBank;
    private String codeBic;
    private String description;
    private String inn;
    private String name;
    private String adress;
    private String phone;

    public ReestrBank() {
    }

    public ReestrBank(Long idBank, String codeBic, String inn, String name) {
        this.idBank = idBank;
        this.codeBic = codeBic;
        this.inn = inn;
        this.name = name;
    }

    public ReestrBank(Long idBank, String codeBic, String description, String inn, String name, String adress, String phone) {
        this.idBank = idBank;
        this.codeBic = codeBic;
        this.description = description;
        this.inn = inn;
        this.name = name;
        this.adress = adress;
        this.phone = phone;
    }

    public Long getIdBank() {
        return idBank;
    }

    public void setIdBank(Long idBank) {
        this.idBank = idBank;
    }

    public String getCodeBic() {
        return codeBic;
    }

    public void setCodeBic(String codeBic) {
        this.codeBic = codeBic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReestrBank that = (ReestrBank) o;
        return idBank.equals(that.idBank) &&
                codeBic.equals(that.codeBic) &&
                description.equals(that.description) &&
                inn.equals(that.inn) &&
                name.equals(that.name) &&
                adress.equals(that.adress) &&
                phone.equals(that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBank, codeBic, description, inn, name, adress, phone);
    }

    @Override
    public String toString() {
        return "ReestrBank{" +
                "idBank=" + idBank +
                ", codeBic='" + codeBic + '\'' +
                ", description='" + description + '\'' +
                ", inn='" + inn + '\'' +
                ", name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
