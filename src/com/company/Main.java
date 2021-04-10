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
        LinkedList lista1 = new LinkedList();
        lista1.add(1);
        lista1.add(4);
        lista1.add(3);
        lista1.add(7);

    /*for(int i=0;i< lista1.getSize();i++){
        System.out.println("El dato de "+i+" es: "+ lista1.get(i)+"\n");
    }*/


        System.out.println("El tamaño de la lista es: " + lista1.getSize());
        LinkedList.Iterator it = lista1.getIterator();
        LinkedList.ReverseIterator it2 = lista1.getReverseIterator();
        System.out.println("\nImprimir Arreglo con Iterator\n");

        while (it.hasNext()) {
            LinkedList.Iterator backupIt = new LinkedList.Iterator(it);
            int element = it.next(); //regresa el dato y avanza el iterador
            System.out.println("Dato:" + element);
            if (element == 3) {
                lista1.insert(10, Position.BEFORE, backupIt);
            }
            if (element == 7) {
                lista1.insert(15, Position.AFTER, backupIt);

            }

        }
        System.out.println("\nImprimir Arreglo con Reverseterator\n");
        it=lista1.getIterator();
        while(it2.hasPrevious())

        {
            int element = it2.previous(); //regresa el dato y avanza el iterador
            System.out.println("Dato:" + element);
        }
    }
}



