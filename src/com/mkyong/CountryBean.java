package com.mkyong;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.event.ValueChangeEvent;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

@ManagedBean(name = "country")
@SessionScoped
public class CountryBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Map<String, String> countries;
    private Map<String, String> statesBackup;
    private Map<String, String> states;

    private String localeCode = "en"; //default value
    private String country;
    private String state;

    {
        countries = new LinkedHashMap<String, String>();
        countries.put("United Kingdom", "en"); //label, value
        countries.put("French", "fr");
        countries.put("German", "de");
        countries.put("India", "IN");

        states = new LinkedHashMap<>();
        states.put("State 1", "S1");
        states.put("State 2", "S2");
        states.put("State 3", "S3");
        states.put("Odisha", "OD");
        states.put("Bangalore", "BN");

    }

    public void countryLocaleCodeChanged(ValueChangeEvent e) {
        localeCode = e.getNewValue().toString();

    }

    public Map<String, String> getCountryInMap() {
        return this.countries;
    }

    public String getLocaleCode() {
        return localeCode;
    }

    public void setLocaleCode(String localeCode) {
        this.localeCode = localeCode;
    }

    public Map<String, String> getStates() {
        return states;
    }

    public void setStates(Map<String, String> states) {
        this.states = states;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Map<String, String> getStatesBackup() {
        return statesBackup;
    }

    public void setStatesBackup(Map<String, String> statesBackup) {
        this.statesBackup = statesBackup;
    }

    public void submit(){
        System.out.println("Submitted");
    }

    public void onLoad(ComponentSystemEvent event){
        System.out.println("On load");
    }
}