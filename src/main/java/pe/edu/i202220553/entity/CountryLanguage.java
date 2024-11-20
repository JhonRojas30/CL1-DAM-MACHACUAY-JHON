package pe.edu.i202220553.entity;

import jakarta.persistence.*;

@Entity
public class CountryLanguage {

    @Id
    @Column(name = "CountryCode", nullable = false)
    private String CountryCode;
    @Id
    @Column(name = "Language", nullable = false)
    private String Language;
    private String IsOfficial;
    private Double Percentage;

    //MAPEO DE RELACION------------------
    @ManyToOne
    @MapsId("CountryCode")
    @JoinColumn(name = "CountryCode", nullable = false, insertable = false, updatable = false) // FK
    private Country country;
    //CONTRUCTOR VACIO----------

    public CountryLanguage() {
    }

    //CONTRUCTOR---------------------

    public CountryLanguage(String countryCode, String language, String isOfficial, Double percentage, Country country) {
        CountryCode = countryCode;
        Language = language;
        IsOfficial = isOfficial;
        Percentage = percentage;
        this.country = country;
    }


    //GENERAMOS EL TOSTRING-----------------------

    @Override
    public String toString() {
        return "CountryLanguage{" +
                "CountryCode='" + CountryCode + '\'' +
                ", Language='" + Language + '\'' +
                ", IsOfficial='" + IsOfficial + '\'' +
                ", Percentage=" + Percentage +
                '}';
    }


    //GET AND SET--------------------------

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public String getIsOfficial() {
        return IsOfficial;
    }

    public void setIsOfficial(String isOfficial) {
        IsOfficial = isOfficial;
    }

    public Double getPercentage() {
        return Percentage;
    }

    public void setPercentage(Double percentage) {
        Percentage = percentage;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
