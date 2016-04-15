package com.github.luizclaudiosantos.java8.introduction;

import com.github.luizclaudiosantos.java8.introduction.SortString;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by luizfr on 3/29/16.
 */
public class SortStringTest {

    List<String> values;

    @Before
    public void createList(){
        values = new LinkedList<>();
        values.add("1");
        values.add("333");
        values.add("55555");
        values.add("4444");
        values.add("22");
    }


    private boolean checkOrder(List <String> list){
        int previus = 0;
        for(String value : values){
            System.out.println(value);
            if(value.length() < previus){
                return false;
            }
            previus = value.length();
        }
        return true;
    }

    @Test
    public void sortStringWithoutLambda(){
        new SortString().sortStringWithoutLambda(values);
        assertTrue(checkOrder(values));
    }

    @Test
    public void sortStringWithLambda1(){
        new SortString().sortStringWithoutLambda(values);
        assertTrue(checkOrder(values));
    }

    @Test
    public void sortStringWithLambda2(){
        new SortString().sortStringWithoutLambda(values);
        assertTrue(checkOrder(values));
    }

    @Test
    public void sortStringWithLambda2Extended(){
        new SortString().sortStringWithoutLambda(values);
        assertTrue(checkOrder(values));
    }

    @Test
    public void sortStringWithLambdaMethodReference(){
        new SortString().sortStringWithoutLambda(values);
        assertTrue(checkOrder(values));
    }


}
