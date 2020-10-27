
package com.company;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * @author Andriy Litvinyuk
 * @version 1.0
 */
class Interval{
    private int first;
    private int last;
    private int length;
    /** @param first - first number of interval
     *@param last - last number of interval
     *@param length - length of fibonacci
     */
    public Interval(int first,int last,int length){
        this.first = first;
        this.last = last;
        this.length = length;
    }
    /** Generates array with odd numbers*/
    public ArrayList<Integer> Odd(){
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i = first;i<=last;i++){
            if(i%2==1) {
                res.add(i);
            }
        }
        return res;/** @return Array with odd numbers */
    }
    /** Generates array with even numbers*/
    public  ArrayList<Integer> Even(){
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i = first;i<=last;i++){
            if(i%2==0) {
                res.add(i);
            }
        }
        return res; /** @return Array with even numbers */
    }
    /** Generates array with odd fibbonachi*/
    public ArrayList<Integer> Fibbonacci(){
        int a1,a2; //Встановлення перших двох елементів ряду Фібоначчі
        if(last%2==0){
            a2 = last;
            a1=last-1;
        }
        else {
            a1 = last;
            a2 = last-1;
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(a1);
        res.add(a2);
        int t;
        double even = 1,odd = 1;
        for(int i = 2;i<length;i++) { //Генерування ряду Фібоначчі
            t = a1 + a2;
            if (t % 2 == 0) even++;
            else odd++;
            res.add(t);
            a1 = a2;
            a2 = t;
        }
        return res; /** @return Array with Fibonacci */
    }
    /** Calculates percentage of odd numbers in Fibonacci */
    public double OddRate(){
        ArrayList<Integer> lst = Fibbonacci();
        double count = 0;
        for(int i:lst){
            if(i%2==1)count++;
        }
        return count/lst.size()*100;/** @return Percentage of odd numbers */
    }
    /** Calculates percentage of even numbers in Fibonacci */
    public double EvenRate(){
        ArrayList<Integer> lst = Fibbonacci();
        double count = 0;
        for(int i:lst){
            if(i%2==0)count++;
        }
        return count/lst.size()*100;/** @return Percentage of even numbers */
    }
    /** Calculates sum of odd numbers */
    public int OddSum(){
        ArrayList<Integer> odd = Odd();
        int sum = 0;
        for(int i:odd) sum += i;
        return sum;/** @return Sum of interval odd numbers */
    }
    /** Calculates sum of even numbers */
    public int EvenSum(){
        ArrayList<Integer> even = Even();
        int sum = 0;
        for(int i:even) sum += i;
        return sum;/** @return Sum of interval even numbers */
    }

    @Override
    public String toString() {
        return "Парні:\n"+Even().toString() + "\nСума:"+EvenSum()+"\nНепарні:\n"+Odd().toString()+
                "\nСума:"+OddSum() +"\nРяд Фібоначчі:\n"+Fibbonacci().toString()+"\nПарних:"+
                EvenRate()+"%\nНепарних:"+OddRate()+"%";
    }
}
/**
 * @author Andriy Litvinyuk
 * @version 1.0
 */
public class Main {
/**
    @param args - standard parameter
     */

    public static void main(String[] args) {
        Scanner in = new Scanner((System.in));
        int first,last;
        int length;
        System.out.println("Введіть інтервал:");
        first = in.nextInt();
        last = in.nextInt();
        System.out.println("Введіть довжину ряду Фібоначчі:");
        length = in.nextInt();
        Interval a = new Interval(first,last,length);
        System.out.println(a.toString());

    }
}
