/*
 * Copyright 2018, Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.SimpleCalc;

import android.test.suitebuilder.annotation.SmallTest;

import org.hamcrest.number.IsCloseTo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * JUnit4 unit tests for the calculator logic. These are local unit tests; no device needed
 */
@RunWith(JUnit4.class)
@SmallTest
public class CalculatorTest {

    private Calculator mCalculator;

    /**
     * Set up the environment for testing
     */
    @Before
    public void setUp() {
        mCalculator = new Calculator();
    }

    /**
     * Test for simple addition
     */
    @Test
    public void addTwoNumbers() {
        double resultAdd = mCalculator.add(1d, 1d);
        assertThat(resultAdd, is(equalTo(2d)));
    }

    @Test
    public void addTwoNumbersNegative() {
        assertThat(mCalculator.add(-1d,-1d),is(equalTo(-2d)));
    }

    @Test
    public void addTwoNumbersFloats() {
        double resultAdd = mCalculator.add(1.111f, 1.111d);
        assertThat(resultAdd, is(IsCloseTo.closeTo(2.222, 0.01)));
    }

    @Test
    public void subTwoNumbers(){
        assertThat(mCalculator.sub(4d,2d),is(equalTo(2d)));
    }

    @Test
    public void subWorksWithNegativeResults(){
        assertThat(mCalculator.sub(4d,8d),is(equalTo(-4d)));
    }

    @Test
    public void mulTwoNumbers(){
        assertThat(mCalculator.mul(2d,2d),is(equalTo(4d)));
    }

    @Test
    public void mulTwoNumbersZero(){
        assertThat(mCalculator.mul(2d,0d),is(equalTo(0d)));
    }

    @Test
    public void divTwoNumbers() {
        double resultDiv = mCalculator.div(32d,2d);
        assertThat(resultDiv, is(equalTo(16d)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void divByZeroThrows(){
        mCalculator.div(32d,0);
    }

    @Test
    public void powPositiveIntegers(){
        assertThat(mCalculator.pow(2d,3d),is(equalTo(8d)));
    }

    @Test
    public void powOfNegativeBaseInteger(){
        assertThat(mCalculator.pow(-3d,2d),is(equalTo(9d)));
    }

    @Test
    public void powOfNegativePowerInteger(){
        assertThat(mCalculator.pow(2d,-1d),is(equalTo(0.5d)));
    }

    @Test
    public void powOfBaseZero(){
        assertThat(mCalculator.pow(0d,2d),is(equalTo(0d)));
    }

    @Test
    public void powOfPowerZero(){
        assertThat(mCalculator.pow(2d,0d),is(equalTo(1d)));
    }

    @Test
    public void powOfBaseZeroPowerAtNegativePower(){
        assertThat(mCalculator.pow(0d,-2d),is(equalTo(Double.POSITIVE_INFINITY)));
    }

    @Test
    public void powOfNegativeBaseZeroPowerAtNegativePower(){
        assertThat(mCalculator.pow(-0d,-2d),is(equalTo(Double.POSITIVE_INFINITY)));
    }
}