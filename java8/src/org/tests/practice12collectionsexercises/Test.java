package org.tests.practice12collectionsexercises;

/**
 * isEmpty returns true if the list has no elements
 * clear remove all elements on the list
 * contains validates if the sent object exist in the list
 * get gets the object in the sent index, might generate indexoutofboundsexception
 * indexOf returns the first index of the sent object, if not present returns -1
 * lastIndexOf retursn the index of the last matching object if not present returns -1
 * remove  if object sent return boolean, if index sent returns deleted element, indexes are reordered if many elements match delete only the first element matching
 * removeAll only receives another collection and removes that elements, all matchin elements are removed, if a match exists multiple all matching are removed
 * retainAll will remove all elements in the collection except for those present in the collection sent as parameter
 * size returns the size of the collection
 * subList will return a sublist of this list according to the startindex, endindex sent
 * toArray will convert list to array, will have to include kind of array on constructor lista.toArray(new String[0]);
 * trimToSize   trim list to the correct size (in case capacity was declared or is bigger than the real elements)
 * containsAll  if argument list contains exact the same elements than the list then return true
 * forEach will receive and execute a Consumer
 * sort will sort based on the Comparator argument
 * set updates the element of the specified index with the specified value
 * removeIf will remove the elements matching the predicate
 *
 * Map
 * get will return the value object matching the key sent, if not present return null
 * put will add one element to the map, if key already exist it will be replaced for the new value
 * containsKey will return true if the sent key exists on the map
 * ContainsValue will return true if the sent value exists on the map
 * entrySet returns a Set with all map values
 * keySet will return a Set with all existing keys on the map
 * values will return a Set with all existing values on the map
 *
 * Collections
 * sort will sort on natural order or according with the comparator if sent
 * reverse reverses the order or the collection sent
 * unmodifiable will return an unmodifiable collection, the one used as value is not affected and not unmodifiable, if you modified the used value on the same class the unmodifiable
 * returned will also have that modification
 * synchronized returns a threadsafe collection
 * rotate rotates the list by a given distance to the right
 * min min value on the list
 * max max value on the list
 * indexOfSublist int index of the sulist in the list
 */

import java.util.*;

public class Test {
    public static void main(String [] args){
        List<Integer> numeros = new ArrayList<>();
        numeros.add(10); numeros.add(4); numeros.add(1); numeros.add(7); numeros.add(9); numeros.add(0); numeros.add(3); numeros.add(5);
        System.out.println(numeros);


        List<String> cadenas = new ArrayList<>();
        cadenas.add("Fernando"); cadenas.add("Zazil"); cadenas.add("Gabriela"); cadenas.add("Nadia"); cadenas.add("Victoria"); cadenas.add("Jose"); cadenas.add("Mariana");

        //isEmpty
        System.out.println(numeros.isEmpty());

        //clear
        numeros.clear();
        System.out.println(numeros.isEmpty());

        //contains
        System.out.println(cadenas.contains("Zazil"));
        System.out.println(cadenas.contains("Joaquin"));

        String palabra = "ANA PAULINA";
        List<String> vocales = new ArrayList<>();
        vocales.add("A"); vocales.add("E"); vocales.add("I"); vocales.add("O"); vocales.add("U"); vocales.add("E"); vocales.add("E");

        Map<String,Integer> mapavocales = new HashMap<>();

        char c[] = palabra.toUpperCase().toCharArray();
        for(char car: c){
            String carString = String.valueOf(car);
            if(vocales.contains(carString)){
                if(mapavocales.containsKey(carString)){
                    int i = mapavocales.get(carString);
                    mapavocales.put(carString, i+1);
                }
                else{
                    mapavocales.put(carString, 1);
                }
            }
        }
        System.out.println(mapavocales);

        //remove removeAll
        List<String> removing = new ArrayList<>();
        removing.add("A");removing.add("A"); removing.add("A"); removing.add("A"); removing.add("A"); removing.add("A");
        System.out.println(removing);
        removing.remove(0);
        System.out.println(removing);
        System.out.println(removing.remove(0));
        System.out.println(removing);
        System.out.println(removing.remove("A"));
        System.out.println(removing);

        List<String> removing2 = new ArrayList<>();
        removing2.add("A");
        System.out.println(removing.removeAll(removing2));
        System.out.println(removing);

        //retainAll
        System.out.println(vocales.retainAll(removing2));
        System.out.println(vocales);

        //sublist
        List<String> lista = new ArrayList<>();
        lista.add("A"); lista.add("E"); lista.add("I"); lista.add("O"); lista.add("U");
        List<String> stringList = lista.subList(2, 3);
        System.out.println(stringList);

        //toArray
        lista.add("A"); lista.add("E"); lista.add("I"); lista.add("O"); lista.add("U");
        System.out.println("toarray" +lista);
        String [] array = lista.toArray(new String[0]);
        for(String s : array){
            System.out.print(s);
        }
        System.out.println();

        //containsAll
        List<String> container = new ArrayList<>();
        container.add("A");
        List<String> container2 = new ArrayList<>();
        container2.add("A"); container.add("I");
        System.out.println(container2.containsAll(container));

        //foreach
        List<String> foreachlist = new ArrayList<>();
        foreachlist.add("A"); foreachlist.add("E"); foreachlist.add("I"); foreachlist.add("O"); foreachlist.add("U");
        System.out.println("ForEach");
        foreachlist.forEach(s->{
            System.out.print(s);
        });
        System.out.println();

        //sort
        Comparator<String> ferComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        };
        foreachlist.sort(ferComparator);
        System.out.println(foreachlist);

        //set
        foreachlist.set(1,"Z");
        System.out.println(foreachlist);

        //removeIf
        foreachlist.removeIf(s-> s.equals("Z"));
        System.out.println(foreachlist);

        //mapget
        System.out.println(mapavocales.get("X"));

        //containsValue
        System.out.println(mapavocales.containsValue(4));

        //entrySet
        System.out.println(mapavocales);
        System.out.println(mapavocales.entrySet());

        //keySet
        System.out.println(mapavocales.keySet());

        //values
        System.out.println(mapavocales.values());

        //CollectionsSort
        List<String> collection = new ArrayList<>();
        collection.add("Fer"); collection.add("Victor"); collection.add("Zazil"); collection.add("Zita"); collection.add("Gaby");
        Collections.sort(collection);
        System.out.println(collection);
        Collections.sort(collection, ferComparator);
        System.out.println(collection);

        //collections reverse
        numeros.add(10); numeros.add(4); numeros.add(1); numeros.add(7); numeros.add(9); numeros.add(0); numeros.add(3); numeros.add(5);
        System.out.println(numeros);
        Collections.reverse(numeros);
        System.out.println(numeros);

        //unmodifiableCollection
        Collection<Integer> numeros2 = Collections.unmodifiableCollection(numeros);
        System.out.println("num2" +numeros2);

        //rotate
        List<String> frutas = new ArrayList<>();
        frutas.add("Pera"); frutas.add("Manzana"); frutas.add("Uva"); frutas.add("Mango"); frutas.add("Sandia");
        System.out.println(frutas);
        Collections.rotate(frutas,3);
        System.out.println(frutas);

        //min max
        System.out.println(numeros);
        System.out.println(Collections.max(numeros));
        System.out.println(Collections.min(numeros));
        System.out.println(Collections.max(frutas));
        System.out.println(Collections.min(frutas));

        //indexOfSubList
        List<String> frutas2 = new ArrayList<>();
        frutas2.add("Pera"); frutas2.add("Manzana");
        System.out.println(Collections.indexOfSubList(frutas2, frutas));

    }
}
