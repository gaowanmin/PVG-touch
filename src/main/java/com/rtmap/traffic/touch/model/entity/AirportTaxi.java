package com.rtmap.traffic.touch.model.entity;

public class AirportTaxi {
    private Integer airportTaxiId;

    private String airport;

    private String terminal;

    private String address;

    private String airportName;

    public Integer getAirportTaxiId() {
        return airportTaxiId;
    }

    public void setAirportTaxiId(Integer airportTaxiId) {
        this.airportTaxiId = airportTaxiId;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName == null ? null : airportName.trim();
    }
}