package com.ex2.country.service;

import java.net.URL;
import java.util.List;
import com.ex2.country.model.Country;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class InternetCountryService
{

    private static final ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private List<Country> readCountriesFromAPI()
    {
        try
        {
            URL url = new URL("https://restcountries.com/v3.1/all");
            return objectMapper.readValue(url, new TypeReference<>()
            {
            });
        }
        catch (Exception e)
        {
            throw new IllegalStateException("Could not read country data", e);
        }
    }

    public List<Country> getAll()
    {
        return readCountriesFromAPI();
    }

}
