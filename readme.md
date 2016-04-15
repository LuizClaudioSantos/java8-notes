
#Java 8

This repository is a compilation of notes to myself about Java 8, if you want to make any comments  in it, please go ahead.

  
## Introduction


Let's see how can we sort the list of the String by size in Java7. Tosort the list, here I' using the static method sort(List<T> list, Comparator<? super T> c) of the class Collection. Using an anonimus implementation of the interface Comparator the code become too much verbose.


```
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

```

To test it I wrote a  simple unit test:

```
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

```

Up to here, nothing new, we just used the old Java way to sort a array. Now let use a Lambda expression. 

Look for the second parameter of the method, now instead a anonymous class we are using a lambda expression.
 
Note that in the first part of the lambda expession we used the "(s1, s2)", we didn't declare the type of s1 and s2, the compiler namager to infere that they are both string. 

In the second part of the lambda expression, we are using the method compareTo from the class Integer, this method compare to int and return 1 or 0 or -1, in the same way that the implemenation of Comparetor interface that did before.

```

   public List<String> sortStringWithLambda1(List<String> list){
       Collections.sort(list, (s1, s2) -> new Integer(s1.length()).compareTo(s2.length()) );
       return list;
   }

```


I also did a unit test to test it:

```
    @Test
    public void sortStringWithLambda1(){
        new SortString().sortStringWithoutLambda(values);
        assertTrue(checkOrder(values));
    }
```



