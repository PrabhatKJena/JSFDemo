package com.mkyong;

import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;
import java.util.HashMap;
import java.util.HashSet;

public class CountryValueListener implements ValueChangeListener {

    @Override
    public void processValueChange(ValueChangeEvent event) throws AbortProcessingException {
        CountryBean country = (CountryBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("country");
        country.setLocaleCode(event.getNewValue().toString());
        if(country.getStatesBackup() == null){
            country.setStatesBackup(new HashMap<>(country.getStates()));
        }
        if("IN".equals(event.getNewValue())){
            country.getStates().remove("State 1");
            country.getStates().remove("State 2");
            country.getStates().remove("State 3");
        }else{
            country.setStates(new HashMap<>(country.getStatesBackup()));
        }

    }

}