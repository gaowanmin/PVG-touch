package com.rtmap.traffic.touch.model.entity;

public class TaxiCosts {
    private Integer id;

    private String airport;

    private String terminal;

    private String airportName;

    private String end;

    private String endEn;

    private String distance;

    private String price;

    private String nightPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport == null ? null : airport.trim();
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal == null ? null : terminal.trim();
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName == null ? null : airportName.trim();
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end == null ? null : end.trim();
    }

    public String getEndEn() {
        return endEn;
    }

    public void setEndEn(String endEn) {
        this.endEn = endEn == null ? null : endEn.trim();
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance == null ? null : distance.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getNightPrice() {
        return nightPrice;
    }

    public void setNightPrice(String nightPrice) {
        this.nightPrice = nightPrice == null ? null : nightPrice.trim();
    }
}