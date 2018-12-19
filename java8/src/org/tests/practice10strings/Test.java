package org.tests.practice10strings;

import java.util.ArrayList;
import java.util.List;

/**
 * compareTo  returns int, left bigger return positive
 * contains return true if the string contains the evaluated string
 * substring int index inicio int index final returns the substring
 * replaceAll remplace given expression with second expression.
 * replace  replace all coincidences of the given expression with the second expression
 * isEmpty true if length equal 0
 * charAt send index to the string and will return the character of that position
 * toCharArray convert a string to a char array
 * concat concats a String with the given String
 * contentEquals compares content event among different types (ex sb) if content is equal returns true no matter types
 * endsWith returns true if the string ends exactly with the regex sent
 * getChars gives you more flexibility than tochararray, allows to specify where in the word to begin, to end, to which char array and in which position of the array will start
 * indexOf returns the position of the first matching of the expression
 * lastIndexOf returns the last position of the matching of the expression
 * replaceFirst replace only first coincidence of the given expression with the second expression
 * split return an array of strings divided by the sent expression
 * startsWith returns true if the given expression matches the initial string
 * trim removes spaces at the begining and end of the string
 * subsequense returns CharSequence not String like substring
 *
 * String.valueOf(charArray) converts char array, int, long into its string value
 *
 * StringBuilder
 * append
 * deleteCharAt
 * reverse
 * chars return IntStream
 * trimToSize
 */

public class Test {
    public static void main(String [] args){

        List<String> lista = new ArrayList<String>();
        lista.add("Fernando");lista.add("Rodrigo");lista.add("Zazil");lista.add("Chisco");lista.add("Gaby");lista.add("Nayeli");lista.add("Maximiliano");
        System.out.println(lista);
        String a = "nueva cadena";
        String b = "Soy una cadenota";
        StringBuilder sb = new StringBuilder();

        //compareTo
        System.out.println("a".compareTo("c"));

        //compare char
        char n = a.charAt(0);
        if(n=='n'){
            System.out.println("Char igual");
        }

        //contains
        if(a.contains(" ca")) {
            System.out.println("Contiene Cadena");
        }

        //substring
        String ss = "Parangaricutirimicuaro";
        substrings(ss,4);

        //replaceAll
        String remplaceAll ="Esta c  a de   na    ti  ene    un   bu   en  de     es pa  cios";
        System.out.println(remplaceAll.replaceAll(" ",""));

        //replace only more than one space
        replaceOnlyExcedent(remplaceAll);

        //replace
        String ab = "aaabbcbbaaa";
        System.out.println("Replace");
        System.out.println(ab.replace("bb",""));

        //replaceFirst
        System.out.println(ab.replaceFirst("bb",""));

        //isEmpty
        ab="";
        System.out.println(ab.isEmpty());

        //substring
        String partir = "Cadena";
        String firstPart = partir.substring(0, partir.length()/2);
        String secondPart = partir.substring(partir.length()/2, partir.length());
        System.out.println(firstPart);
        System.out.println(secondPart);

        //concat
        String hola = "Hola ";
        String fer = "Fer";

        System.out.println(hola.concat(fer));

        //contentEquals
        String s = "Cadena";
        StringBuffer stringBuffer = new StringBuffer("Cadena");
        System.out.println(s.equals(stringBuffer));
        System.out.println(s.contentEquals(stringBuffer));

        //endsWith
        System.out.println(s.endsWith("ena."));

        //String.valueOf
        char [] arreglin = new char[]{'c','a','b','r','o','n'};
        System.out.println(String.valueOf(arreglin));

        //indexOf
        String indexes = "cacacacacaca";
        System.out.println(indexes.indexOf("ca"));
        System.out.println(indexes.lastIndexOf("ca"));

        //split
        String splitter = "Esta, es, una, cadena, con, muchas, comas";
        String [] splitters = splitter.split(",");
        for(String s1: splitters){
            System.out.print(s1);
        }

        //startsWith
        String abcd = "abcd";
        System.out.println();
        System.out.println(abcd.startsWith("ab"));
        System.out.println(abcd.startsWith("aab"));

        //trim
        String trimmer = "       A    V   E   SSI   ON     ";
        System.out.println(trimmer.trim());

        //subsequence
        System.out.println(indexes.subSequence(0,4));

    }

    public static void substrings(String cadena, int tamano){
        int reps = cadena.length()/tamano;
        int rest = cadena.length()%tamano;
        int i=0;
        for(int j=0;j<reps;j++){
            System.out.println(cadena.substring(i,i+tamano)+ " ");
            i+=tamano;
        }
        if(rest>0){
            System.out.println(cadena.substring(i,i+rest));
        }
    }

    public static void replaceOnlyExcedent(String cadena){
        char [] cadenarrey = cadena.toCharArray();
        StringBuffer sb = new StringBuffer();
        boolean dup = false;
        int i=0;
        for(char c: cadenarrey){
            if(c==' ') {
                if(!dup){
                    sb.append(c);
                }
                dup= true;
            }
            else{
                sb.append(c);
                dup = false;
            }
            i++;
        }
        System.out.println(sb.toString());
    }
}
