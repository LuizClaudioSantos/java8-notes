package com.github.luizclaudiosantos.java8.introduction;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/**
 * Created by luizfr on 3/29/16.
 */
public class SortString {

    public List<String> sortStringWithoutLambda(List<String> list){
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String first, String second) {
                if(first.length() > second.length()){
                    return 1;
                }else if (first.length() < second.length()){
                    return -1;
                }else{
                    return 0;
                }
            }
        });
        return list;
    }

    public List<String> sortStringWithLambda1(List<String> list){
        Collections.sort(list, (s1, s2) -> new Integer(s1.length()).compareTo(s2.length()) );
        return list;
    }

    public List<String> sortStringWithLambda2(List<String> list){
        list.sort(Comparator.comparing(s -> s.length()));
        return list;
    }

    public List<String> sortStringWithLambda2Extended(List<String> list){
        Function<String, Integer > functionExtrator = s -> s.length();
        Comparator <String> comparator  = Comparator.comparing(functionExtrator);
        list.sort(comparator);
        return list;
    }

    public List<String> sortStringWithLambdaMehtodReference(List<String> list){
        list.sort(Comparator.comparing(String::length));
        return list;
    }

}
