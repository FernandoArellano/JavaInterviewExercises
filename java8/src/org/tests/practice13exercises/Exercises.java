package org.tests.practice13exercises;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Exercises {

    public static void main(String [] args){

        //fibonacci
        System.out.println(fibonacci(12));

        //print all fibonacci sequence
        fibonacci2(12);

        //prime number
        prime(7);

        //palindrom
        palindrome("aaabbaaa");

        //int palindrome
        intpalindrome(2332);

        //armstrong
        armstrong(153);

        //factorial
        factorial(5);

        //factorial recursion
        System.out.println(factorialRecursion(5));

        //remove duplicates from list
        List<Integer> numeros = new ArrayList<>();
        numeros.add(10);numeros.add(4);numeros.add(4);numeros.add(0);numeros.add(1);numeros.add(1);numeros.add(2);numeros.add(5);
        System.out.println(numeros);
        Set<Integer> set = new LinkedHashSet<>(numeros);  //linkedhashset keeps order
        System.out.println(set);
        List<Integer> nuevaLista = removeDuplicatesList(numeros);
        System.out.println(nuevaLista);

        //bubble sort
        int[] a = new int[]{5,4,6,8,9,1};
        for(int x : a){
            System.out.print(x);
        }
        System.out.println();
        a= bubbleSort(a);
        for(int x : a){
            System.out.print(x);
        }
        System.out.println();

        //remove duplicates arrayStream
        int[] b = new int[]{6,4,4,4,5,6,7,8,7,6,6};
        b = removeDuplicatesArrayStream(b);
        for(int x : b){
            System.out.print(x);
        }
        System.out.println();

        //convert int[] to Integer[]
        Integer[] c = convertIntArrayToIntegerArray(b);
        c= removeDuplicatesArrayStream(c);
        for(int x : c){
            System.out.print(x);
        }
        System.out.println();

        //is Anagram Arrays API
        System.out.println(isAnagramArrays("Fernando","odnanreF"));

        //is Anagram No Apis
        System.out.println(isAnagramNoApi("Gabai","aGabi"));

        //first non repetead character
        firstNotRepeatedCharacter("Fernando");

        //find middle value
        System.out.println(middleValue(new int[]{5,10,20,25}));

        //find ordered middle value
        System.out.println(orderedMiddleValue(new int[]{15,4,25,0}));

        //remove whitespaces String replace
        removeAllWhiteSpaces("soy una cadena con espacios  y vamos agregando poco mas cositas    s    ");

        //remove character without replace
        removeCharacter(' ',"soy otra palabra q tiene espacios    ");

        //reverse List
        List<String> lista = new LinkedList<String>();
        lista.add("A"); lista.add("B"); lista.add("C"); lista.add("D"); lista.add("E");
        reverseLinkedList(lista);

        //reverse list no api
        reverseListNoApi(lista);

        //count vowels and consonants in string
        countVowelsAndConsonants("Fernando");

        //int value of string
        intValueOfString("Fernando");

        //string is substring
        isSubstring("Fernando", "ern");

        //highest ocurred
        highestOcurred("Parangaricutirimicuaro");

        //comparable
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(30, 10, "Fer")); employeeList.add(new Employee(33, 7, "Fer2"));
        employeeList.add(new Employee(35, 15, "Fer3")); employeeList.add(new Employee(32, 1, "Fer4")); employeeList.add(new Employee(23, 50, "Fer5"));
        comparable(employeeList);

        //comparator
        comparator(employeeList);

        //pascal triangle
        pascalTriangle(5);

        //permutation finder
        System.out.println(permutationFinder("abc"));

        //prime optimized
        primeOptimized(100);

        //number pyramid
        numberPyramid(7);

        //armstrong 2
        armstrong2(123);

        //remove duplicates from array not api
        removeDuplicatesArrayNotApi(new int[]{10,10,10,10,5,7,8,9,11,9,11});

        //find duplicate values not api
        findDuplicatesArrayNotApi(new int[]{10,10,10,10,5,7,8,9,11,9,11});

        //second largest
        secondLargest(new int[]{10,10,10,10,5,7,8,9,11,9,11});

        //isbinary
        isBinarynumber(101010);
        isBinarynumber(105456);

        //check if is a number
        isANumber("4546");
        isANumber("No");

        //reverse all words
        reverseAllWords("Vamos America Somos los campeones");

        //move zeros to end program
        moveZerosToEnd(new int[]{15,0,0,0,1,2,5,10,8,5,4,0,15,0});

        //randomNumber
        randomNumber();

        //random number 2
        randomNumber2();

        //rotate array
        rotateToLeft(new int[]{1,2,3,4,5,6,7}, 3);

        replaceVowels("vamos America!");
    }

    public static int fibonacci(int num){
        if(num==1||num==2){
            return 1;
        }
        return fibonacci(num-1)+fibonacci(num-2);
      }

    public static void fibonacci2(int num){
        int fibo1= 1;
        int fibo2= 1;
        System.out.print(fibo1+" ");
        for(int i=2; i<=num;i++){
            System.out.print(fibo2+ " ");
             fibo2= fibo1+fibo2;
             fibo1=fibo2-fibo1;
        }
        System.out.println();
    }

    public static void prime(int num){
        int divider = num /2;
        boolean flag =false;
        if(num==0 || num==1){
            System.out.println("not prime");
        }
        else{
            for(int i=2; i<=divider;i++){
                if(num%i==0){
                    System.out.println("not prime");
                    flag=true;
                    break;
                }
            }
            if(!flag){
                System.out.println("prime number");
            }
        }
    }

    public static void palindrome(String palabra){
        int tamano = palabra.length();
        int rep = palabra.length()/2;
        char[] array = palabra.toCharArray();
        for(int i=0;i<rep;i++){
            char temp = array[tamano-i-1];
            array[tamano-i-1] = array[i];
            array[i]= temp;
        }
        if(palabra.equals(String.valueOf(array))){
            System.out.println(palabra + " is palindrom");
        }
        else{
            System.out.println(palabra + " is not palindrome");
        }
    }

    public static void intpalindrome(int number){
        int reverse = 0;
        int palindrome = number;
        while(palindrome>0){
            int reminder = palindrome %10;
            reverse = reverse*10+reminder;
            palindrome = palindrome/10;
        }
        if(number==reverse){
            System.out.println(number + " is palindrome");
        }
        else{
            System.out.println(number + " is not palindrome");
        }

    }

    public static void armstrong(int number){
        int armstrong = number;
        int sum = 0;
        while(armstrong>0){
            int reminder = armstrong%10;
            sum = sum + (reminder*reminder*reminder);
            armstrong = armstrong/10;
        }
        if(sum==number){
            System.out.println(number + " is armstrong");
        }
        else{
            System.out.println(number + " is not armstrong");
        }
    }

    public static void factorial(int number){
        int sum=1;
        for(int i=number; i>0; i--){
            sum = sum*i;
        }
        System.out.println(sum);
    }

    public static int factorialRecursion(int number){
        if(number==1){
            return 1;
        }
        else{
            return number*factorialRecursion(number-1);
        }
    }

    public static List<Integer> removeDuplicatesList(List<Integer> lista){
        return lista.stream().distinct().collect(Collectors.toList());
    }

    public static int[] bubbleSort(int[] array){
        int length = array.length;
        for(int i=0; i<length-1;i++){
            for(int j=0; j< length-i-1;j++){
                if(array[j]>array[j+1]){
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    public static char[] bubbleSortChar(char[] array){
        int length = array.length;
        for(int i=0; i<length-1;i++){
            for(int j=0; j< length-i-1;j++){
                if(array[j]>array[j+1]){
                    char temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    public static int[] removeDuplicatesArray(){
        return new int[]{};
    }

    public static int[] removeDuplicatesArrayStream(int [] array){
        List<Integer> list = new ArrayList<>();
        for(int n: array){
            list.add(n);
        }
        List<Integer> newList = list.stream().distinct().collect(Collectors.toList());
        int [] newArray = new int[newList.size()];
        for(int i=0; i<newList.size();i++){
            newArray[i]= newList.get(i);
        }
        return newArray;
    }

    public static Integer[] removeDuplicatesArrayStream(Integer [] array){
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(array));
        List<Integer> newList = list.stream().distinct().collect(Collectors.toList());
        Integer [] newArray = new Integer[newList.size()];
        for(int i=0; i<newList.size();i++){
            newArray[i]= newList.get(i);
        }
        return newArray;
    }

    public static Integer[] convertIntArrayToIntegerArray(int [] array){
        IntStream stream = IntStream.of(array);
        return stream.boxed().toArray(Integer[]::new);
    }

    public static boolean isAnagramArrays(String word1, String word2){
        char [] w1 = word1.toCharArray();
        char [] w2 = word2.toCharArray();
        Arrays.sort(w1);
        Arrays.sort(w2);
        return Arrays.equals(w1,w2);
    }

    public static boolean isAnagramNoApi(String word1, String word2){
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        bubbleSortChar(w1);
        bubbleSortChar(w2);
        String s1 = new String(w1);
        String s2 = new String(w2);
        return s1.equals(s2);
    }

    public static void firstNotRepeatedCharacter(String word){
        char[] array = word.toCharArray();
        List<Character> list = new LinkedList<>();
        for(char c: array){
            list.add(c);
        }
        Map<Character,Integer> map = new LinkedHashMap<>();
        boolean found= false;
        list.stream().forEach(character -> {
                if(map.containsKey(character)){
                    int i = map.get(character);
                    map.put(character,i+1);
                }
                else{
                    map.put(character,1);
                }
        });
        System.out.println(map);
        for(Map.Entry<Character,Integer> e: map.entrySet()){
            if(e.getValue()==1&&!found){
                System.out.println(e + " First Ocurrance");
                found= true;
                break;
            }
        }
        if(!found){
            System.out.println("None has 1 ocurrance only on " +word);
        }
    }

    public static int middleValue(int []array){
        int length = array.length;
        int middle;
        if(length%2==0){
            middle = (array.length/2)-1;
        }
        else{
            middle = (array.length/2);
        }
        return array[middle];
    }

    public static int orderedMiddleValue(int [] array){
        IntStream stream = IntStream.of(array);
        List<Integer> list = stream.boxed().sorted().collect(Collectors.toList());
        int position;
        if(list.size()%2==0){
            position = (list.size()/2)-1;
        }
        else{
            position = list.size()/2;
        }
        return list.get(position);
    }

    public static void removeAllWhiteSpaces(String word){
        System.out.println(word.replaceAll(" ",""));
    }

    public static void removeCharacter(char car, String palabra){
        char[] charArray = palabra.toCharArray();
        char[] newCharArray = new char[charArray.length];
        int tam = 0;
        for(int i=0; i<charArray.length;i++){
            if(charArray[i]!=car){
                newCharArray[tam]=charArray[i];
                tam++;
            }
        }
        for(int i=0;i<newCharArray.length;i++){
            System.out.print(newCharArray[i]);
        }
        System.out.println();
    }

    public static void reverseLinkedList(List<String> lista){
        System.out.println(lista);
        Collections.reverse(lista);
        lista.stream().forEach(System.out::print);
        System.out.println();
    }

    public static void reverseListNoApi(List<String> lista){
        int size = lista.size();
        System.out.println(lista);
        for(int i=0;i<lista.size()/2;i++){
            String temp = lista.get(size-i-1);
            lista.set(size-i-1,lista.get(i));
            lista.set(i,temp);
        }
        System.out.println(lista);
    }

    public static void sortList(List<String> lista){
        lista.sort(Comparator.reverseOrder());
    }

    public static void countVowelsAndConsonants(String word){
        List<String> vowels = new ArrayList<>();
        vowels.add("A"); vowels.add("E"); vowels.add("I"); vowels.add("O"); vowels.add("U");
        List<String> consonants = new ArrayList<>();
        consonants.add("B");consonants.add("C");consonants.add("D");consonants.add("F");consonants.add("G");consonants.add("H");consonants.add("J");consonants.add("K");consonants.add("L");consonants.add("M");consonants.add("N");consonants.add("P");consonants.add("Q");consonants.add("R");consonants.add("S");consonants.add("T");consonants.add("V");consonants.add("W");consonants.add("X");consonants.add("Y");consonants.add("Z");
        long numvowels = 0;
        long numconsts = 0;
        char [] array = word.toUpperCase().toCharArray();
        List<String> wordList = new ArrayList<>();
        for(char c: array){
            wordList.add(String.valueOf(c));
        }
        numvowels= wordList.stream().filter(s->vowels.contains(s)).count();
        numconsts = wordList.stream().filter(s->consonants.contains(s)).count();
        System.out.println("Num Vowels: " +numvowels + " Num Consonants: " + numconsts + " in word: " + word);

    }

    public static void intValueOfString(String word){
        char [] array = word.toCharArray();
        int [] intArray = new int[word.length()];
        for(int i = 0; i<word.length();i++){
            intArray[i] = array[i];
        }
        IntStream.of(intArray).forEach(i-> System.out.print(i+","));
        System.out.println();
    }

    public static void isSubstring(String s, String ss){
        if(s.indexOf(ss)!=-1){
            System.out.println("is ss");
        }
        else{
            System.out.println("not ss");
        }
    }

    public static void highestOcurred(String word){
        char[] array = word.toCharArray();
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        AtomicInteger result = new AtomicInteger();
        AtomicReference<String> keyResult = new AtomicReference<>();
        for(char c: array){
            list.add(String.valueOf(c));
        }
       list.stream().forEach(s->{
            int actualValue=0;
            if (map.containsKey(s)) {
                int i = map.get(s);
                actualValue = i+1;
                map.put(s,actualValue);
            }
            else{
                actualValue=1;
                map.put(s,actualValue);
            }
            if(actualValue> result.get()){
                result.set(actualValue);
                keyResult.set(s);
            }
        });
        System.out.println(map);
        System.out.println("Highest: " + keyResult.get() + " with: " +result.get());
    }

    public static void comparable(List<Employee> list){
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

    }

    public static void comparator(List<Employee> list){
        System.out.println("Comparator");
        Comparator<Employee> ageComparator = new Comparator<Employee>(){
            public int compare(Employee e1, Employee e2){
                return e1.age -e2.age;
            }
        };
        System.out.println(list);
        Collections.sort(list, ageComparator);
        System.out.println(list);
    }

    public static void pascalTriangle(int r){
        int i, k, number=1, j;

        for(i=0;i<r;i++)
        {
            for(k=r; k>i; k--)
            {
                System.out.print(" ");
            }
            number = 1;
            for(j=0;j<=i;j++)
            {
                System.out.print(number+ " ");
                number = number * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }

    public static Set<String> permutationFinder(String str) {
        Set<String> perm = new HashSet<String>();
        //Handling error scenarios
        if (str == null) {
            return null;
        } else if (str.length() == 0) {
            perm.add("");
            return perm;
        }
        char initial = str.charAt(0); // first character
        String rem = str.substring(1); // Full string without first character
        Set<String> words = permutationFinder(rem);
        for (String strNew : words) {
            for (int i = 0;i<=strNew.length();i++){
                perm.add(charInsert(strNew, initial, i));
            }
        }
        return perm;
    }

    public static String charInsert(String str, char c, int j) {
        String begin = str.substring(0, j);
        String end = str.substring(j);
        return begin + c + end;
    }

    public static void primeOptimized(int num) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        int ocurrences=0;
        boolean prime = true;
            for(int i=3; i<=num;i+=2){
                ocurrences= 0;
                prime =true;
                if(i%5!=0) {
                    for (int j = 3; j < i; j += 2) {
                        if (i % j == 0) {
                            ocurrences++;
                        }
                        if (ocurrences > 0) {
                            prime = false;
                            break;
                        }
                    }
                }
                else if(i!=5){
                    prime= false;
                }
                if(prime){
                    list.add(i);
                }
            }
        System.out.println(list);
        }

    public static void numberPyramid(int rows){
        for(int i=1; i<=rows;i++){
            for(int j=i; j<=rows;j++){
                System.out.print(" ");
            }
            for(int k=1; k<=i;k++){
                System.out.print(i+ " ");
            }
            System.out.println();
        }


    }

    public static void armstrong2(int number){
        int sum=0;
        while(number>0){
            int reminder = number%10;
            sum = sum + (reminder*reminder*reminder);
            number= number /10;
        }
        System.out.println("Second armstrong: " + sum);
    }

    public static void removeDuplicatesArrayNotApi(int [] array){
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> duplicated = new HashSet<>();
        for(int x: array){
            if(!set.add(x)) {
                duplicated.add(x);
            }
        }
        System.out.println(duplicated);
        }

    public static void findDuplicatesArrayNotApi(int [] array){
        Map<Integer,Integer> map = new HashMap<>();
        for(int x: array){
            if(map.containsKey(x)){
                int actualValue = map.get(x);
                map.put(x,actualValue+1);
            }
            else{
                map.put(x,1);
            }
        }
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue()>1){
                System.out.println(entry);
            }
        }
    }

    public static void secondLargest(int [] array){
        IntStream stream = IntStream.of(array);
        List<Integer> list = stream.boxed().sorted().collect(Collectors.toList());
        System.out.println(list);
        System.out.println(list.get(1));
    }

    public static void isBinarynumber(int num){
        boolean binary= true;
        while(num>0){
            int reminder = num%10;
            if(reminder>1){
                binary = false;
                break;
            }
            num= num/10;
        }
        if(binary){
            System.out.println("is binary");
        }
        else{
            System.out.println("Not binary");
        }
    }

    public static void isANumber(String o){
        try{
            int i = Integer.parseInt(o);
            System.out.println("It is a number");
        }
        catch (NumberFormatException ex){
            System.out.println("Not a number");
        }

    }

    public static void reverseAllWords(String cadena){
        String [] cadenas = cadena.split(" ");
        List<String> lista = new ArrayList<>();
        for(String s:cadenas){
            int divider = s.length()/2;
            int tamano = s.length();
            char [] array = s.toCharArray();
            for(int i=0; i<divider; i++){
                char temp = array[tamano-i-1];
                array[tamano-i-1] = array[i];
                array [i] = temp;
            }
            String newCadena = new String(array);
            lista.add(newCadena);
        }
        System.out.println(lista);
    }

    public static void moveZerosToEnd(int [] array){
        int arrayLength = array.length;
        int [] list = new int[arrayLength];
        int zeroCounter = arrayLength-1;
        int normalIntCounter = 0;
        for(int x: array){
            if(x==0){
                list[zeroCounter] = x;
                zeroCounter--;
            }
            else{
                list[normalIntCounter] = x;
                normalIntCounter++;
            }
        }
       IntStream.of(list).boxed().forEach(i->{
           System.out.print(i+",");
       });
        System.out.println();
    }

    public static void randomNumber(){
        System.out.println(new Random().nextInt(3));
    }

    public static void randomNumber2(){
        int x = (int) (Math.random()*3);
        System.out.println(x);
    }

    public static void rotateToLeft(int [] array, int rotate){
        for(int i=0;i<rotate;i++){
            int temp = array[0];
            for(int j=0; j<array.length-1;j++){
                array[j] = array[j+1];
            }
            array[array.length-1]= temp;
        }
        System.out.println(Arrays.toString(array));
    }

    public static void replaceVowels(String s){
        System.out.println(s.toUpperCase().replaceAll("[AEIOU]",""));
    }

    public static void printMissingNumber(int [] array, int count){
        BitSet bitSet = new BitSet(count);
        for(int number: array){
            bitSet.set(number-1);

        }
    }

    }
