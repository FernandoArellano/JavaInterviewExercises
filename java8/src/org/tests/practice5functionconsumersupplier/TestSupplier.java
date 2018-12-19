package org.tests.practice5functionconsumersupplier;

import java.util.Date;
import java.util.Random;
import java.util.function.Supplier;

public class TestSupplier {
    public static void main(String[] args){
        Supplier<Date> s = ()-> new Date();
        System.out.println(s.get());

        Supplier<String> supplier = ()-> {
            String [] names = {"Fer", "Zazil", "Erika", "Lidia"};
            int min =2;
            int max=3;
            int por = new Random().nextInt(names.length);
            return names[por];
        };
        System.out.println(supplier.get());

        Supplier<String> s2 = ()->{
          String opt  ="";
          for(int i=0; i<6; i++){
              opt = opt + new Random().nextInt(10);
          }
          return opt;
        };
        System.out.println(s2.get());

        Supplier<String> s3 = ()->{
            String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZ#@$";
            int length = symbols.length();
            StringBuffer sb = new StringBuffer();
            for(int i=1; i<=8; i++){
                if(i%2==0){
                    sb.append(new Random().nextInt(10));
                }
                else{
                    sb.append(symbols.charAt(new Random().nextInt(length-1)));
                }
            }
            return sb.toString();
        };
        System.out.println(s3.get());
    }
}
