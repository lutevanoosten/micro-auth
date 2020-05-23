package com.luteflex.microservices.auth;

public class AuthConfiguration {

    private int maximum;
    private int minimum;
    //no-argument constructor
    protected AuthConfiguration()
    {
    }
    //generating getters
    public int getMaximum()
    {
        return maximum;
    }
    public int getMinimum()
    {
        return minimum;
    }
    //genetrating constructor using fields
    public AuthConfiguration(int maximum, int minimum)
    {
        super();
        this.maximum = maximum;
        this.minimum = minimum;
    }
}
