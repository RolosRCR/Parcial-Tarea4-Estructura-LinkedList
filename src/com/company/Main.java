package com.company;

import com.company.list.LinkedList;
import com.company.list.Position;


class contenedor<T>{
    T dato;

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }}


public class Main {

    public static void main(String[] args) {
        contenedor <Integer> contenedor = new contenedor<>();
        LinkedList<Integer> lista1 = new LinkedList<>();
        lista1.add(1);
        lista1.add(4);
        lista1.add(3);
        lista1.add(7);
        LinkedList<Integer>.Iterator it = lista1.getIterator();
        LinkedList<Integer>.ReverseIterator it2 = lista1.getReverseIterator();

        System.out.println("El tamaño de la lista de números es: " + lista1.getSize());
        //System.out.println("\nImprimir Arreglo con Iterator\n");
        System.out.println("\nImprimir Arreglo de números\n");
        while (it.hasNext()) {
            LinkedList<Integer>.Iterator backupIt = lista1.new Iterator(it);
            int element = it.next(); //regresa el dato y avanza el iterador
            System.out.println("Dato:" + element);
            if (element == 3) {
                lista1.insert(10, Position.BEFORE, backupIt);
            }
            if (element == 7) {
                lista1.insert(15, Position.AFTER, backupIt);

            }
        }
        /*System.out.println("\nImprimir Arreglo con Reverseterator\n");
        it=lista1.getIterator();
        while(it2.hasPrevious())
        {
            int element = it2.previous(); //regresa el dato y avanza el iterador
            System.out.println("Dato:" + element);
        }
        */
        LinkedList<String> listaDePalabras=new LinkedList<>();
        listaDePalabras.add("Ana");
        listaDePalabras.add("Juan");
        listaDePalabras.add("Carlos");
        listaDePalabras.add("Karla");
        LinkedList<String>.Iterator itP = listaDePalabras.getIterator();

        System.out.println("El tamaño de la lista de palabras es: " + listaDePalabras.getSize());
        System.out.println("\nImprimir Arreglo de palabras\n");
        while (itP.hasNext()) {
            String element = itP.next(); //regresa el dato y avanza el iterador
            System.out.println("Persona: " + element);
        }
    }
}



