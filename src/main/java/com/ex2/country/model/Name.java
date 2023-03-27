package com.ex2.country.model;

import java.util.Objects;

public class Name
{
    public Name(String official)
    {
        this.official = official;
    }

    public Name()
    {
    }

    private String official;

    public String getOfficial()
    {
        return official;
    }

    public void setOfficial(String official)
    {
        this.official = official;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof Name))
        {
            return false;
        }
        Name name = (Name) o;
        return official.equals(name.official);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(official);
    }
}
