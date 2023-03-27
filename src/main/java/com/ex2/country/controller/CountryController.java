package com.ex2.country.controller;

import java.util.Collections;
import java.util.List;
import com.ex2.country.model.Country;
import com.ex2.country.service.InternetCountryService;

public class CountryController
{
    private final InternetCountryService countryService;

    public CountryController(InternetCountryService countryService)
    {
        this.countryService = countryService;
    }

    public void addCountriesToList(List<Country> countries) {
    }

    public List<Country> getAllCountries() {
        return countryService.getAll();
    }

    public List<Country> getCountriesWithPopulationOver(long minimumPopulation) {
        return Collections.emptyList();
    }

    public List<Country> getLargestCountriesByPopulation(long numberOfCountries) {
        return Collections.emptyList();
    }
}
