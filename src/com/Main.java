package com;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    static Scanner yourMenuCh = new Scanner(System.in);
    static Client client1 = new Client("Oleg Komarnytskyy", 17, 600);
    static int yourMenuChoice;
    static int newPlusCash;
    static int newMinusCash;

    public static void getMenu() {
        System.out.println("\n=== SeventyFly's Bank ===\n");
        Date d = new Date();
        System.out.println("Здраствуйте, " + client1.name + "!\n");
        SimpleDateFormat format1 = new SimpleDateFormat("Сегодня: dd.MM.yyyy\nТекущее время: hh:mm");
        System.out.println(format1.format(d));
        System.out.println("\n1. Проверить свой баланс.");
        System.out.println("2. Засчитать деньги на свой банковский счет.");
        System.out.println("3. Снять деньги с своего банковского счета.");
        System.out.println("4. Выйти.\n");
        System.out.print("Пожалуйста, сделайте Ваш выбор: ");
        yourMenuChoice = yourMenuCh.nextInt();
        if(yourMenuChoice == 1){
            myBalance();
        }
        if(yourMenuChoice == 2){
            addMoney();
        }
        if(yourMenuChoice == 3){
            wdMoney();
        }
        if(yourMenuChoice == 4){
            myExit();
        }else{
            System.out.println("Вы ввели неправильную цифру, попробуйте еще раз внимательно!");
            getMenu();
        }
    }

    public static void myBalance() {
        System.out.println("\n=== SeventyFly's Bank ===\n");
        System.out.println("Ваш текущий баланс - " + client1.cash + " грн.");
        System.out.println("\nВернуться в главное меню? \n1 - Да, пожалуйста!\n2 - Нет, спасибо!\n");
        System.out.print("Пожалуйста, сделайте Ваш выбор: ");
        yourMenuChoice = yourMenuCh.nextInt();
        if(yourMenuChoice == 1){
            getMenu();
        }
        if(yourMenuChoice == 2){
            myExit();
        }else{
            System.out.println("Вы ввели неправильную цифру, попробуйте еще раз внимательно!");
            getMenu();
        }
    }

    public static void addMoney(){
        System.out.println("\n=== SeventyFly's Bank ===\n");
        newPlusCash = client1.getCash();
        System.out.print("Введите, пожалуйста, Вашу суму которою хотите засчитать на счет: ");
        client1.setCash(newPlusCash + yourMenuCh.nextInt());
        int addedCash = client1.cash - newPlusCash;
        System.out.println("Вы успешно добавили на свой банковский счет - " + addedCash + " грн!");
        System.out.println("Ваш текущий баланс счета - " + client1.getCash() + " грн!\n");
        System.out.println("Вернуться в главное меню? \n1 - Да, пожалуйста!\n2 - Нет, спасибо!\n");
        System.out.print("Пожалуйста, сделайте Ваш выбор: ");
        yourMenuChoice = yourMenuCh.nextInt();
        if(yourMenuChoice == 1){
            getMenu();
        }
        if(yourMenuChoice == 2){
            myExit();
        }else{
            System.out.println("Вы ввели неправильную цифру, попробуйте еще раз внимательно!");
            getMenu();
        }
    }

    public static void wdMoney(){
        System.out.println("\n=== SeventyFly's Bank ===\n");
        newMinusCash = client1.getCash();
        System.out.print("Введите, пожалуйста, Вашу суму которою хотите снять с вашего счета: ");
        client1.setCash(newMinusCash - yourMenuCh.nextInt());
        int minusCash = client1.cash - newMinusCash;
        System.out.println("Вы успешно сняли с своего банковского счета: " + Math.abs(minusCash) + " грн!");
        System.out.println("Ваш текущий баланс счета: " + client1.getCash() + " грн!");
        System.out.println("Вернуться в главное меню? \n1 - Да, пожалуйста!\n2 - Нет, спасибо!\n");
        System.out.print("Пожалуйста, сделайте Ваш выбор: ");
        yourMenuChoice = yourMenuCh.nextInt();
        if(yourMenuChoice == 1){
            getMenu();
        }
        if(yourMenuChoice == 2){
            myExit();
        }else{
            System.out.println("Вы ввели неправильную цифру, попробуйте еще раз внимательно!");
            getMenu();
        }
    }


    public static void myExit(){
        System.out.println("\n=== SeventyFly's Bank ===\n");
        System.out.println("Спасибо, что доверяете нам!");
        System.out.println("\n=== SeventyFly's Bank ===\n");
        System.exit(0);
    }

    public static void main(String[] args) {
            getMenu();
    }
}
