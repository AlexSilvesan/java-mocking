package com.ex2.country.model;

import java.util.Arrays;
import java.util.Objects;

public final class Country
{
    private Name name;

    private String[] capital;

    private String region;
    private long population;

    public Country(String countryName, String[] capital, String region, long population)
    {
        this.name = new Name(countryName);
        this.capital = capital;
        this.region = region;
        this.population = population;
    }

    public Country(String countryName)
    {
        this(countryName, new String[]{}, "", 0);
    }

    public Country()
    {

    }

    public Name getName()
    {
        return name;
    }

    public void setName(Name name)
    {
        this.name = name;
    }

    public String getRegion()
    {
        return region;
    }

    public void setRegion(String region)
    {
        this.region = region;
    }

    public String[] getCapital()
    {
        return capital;
    }

    public void setCapital(String[] capital)
    {
        this.capital = capital;
    }

    public String[] getCapitals()
    {
        return getCapital();
    }

    public long getPopulation()
    {
        return population;
    }

    public void setPopulation(long population)
    {
        this.population = population;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof Country))
        {
            return false;
        }
        Country country = (Country) o;
        return name.equals(country.name);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name);
    }

    @Override
    public String toString()
    {
        return "Country{" +
            "name=" + name.getOfficial() +
            ", capitals = " + Arrays.deepToString(capital) +
            ", region='" + region + '\'' +
            ", population=" + population +
            '}';
    }
}
