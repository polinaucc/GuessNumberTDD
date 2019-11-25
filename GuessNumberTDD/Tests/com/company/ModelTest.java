package com.company;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ModelTest {

    Model model;

    @Before
    public void before(){
        model = new Model();
    }

    @Test
    public void rand() throws Exception {
        Assert.assertTrue(model.rand(10, 20)<20 && model.rand(10,20)>10);
    }

    @Test(expected = Exception.class)
    public void randOneArg() throws Exception {
        model.rand(10);
    }

    @Test
    public void randZeroArg() throws Exception {
        model.rand();
        Assert.assertTrue(model.getMax()==100);
    }

    @Test(expected = Exception.class)
    public void randMinMoreThanMax() throws Exception {
        model.rand(58, 27);
    }

    
}