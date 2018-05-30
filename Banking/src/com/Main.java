package com;

import java.util.Scanner;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.NumberFormat ;

public class Main {

 static Scanner yourMenuCh = new Scanner(System.in);
    static double yourMenuChoice;
    static int newPlusCash;
    static int newMinusCash;
    static int indeficatorClient;
    static int ind;
    static double bankCash;

    public static void backToViewMenu() {
        System.out.println("=== Вернуться в начальное меню? ===\n\n1 - Да, пожалуйста!\n2 - Нет, спасибо!\n");
        System.out.print("Пожалуйста, сделайте Ваш выбор: ");
        yourMenuChoice = getDouble();
        if (yourMenuChoice == 1) {
            startView();
        }
        if (yourMenuChoice == 2) {
            myExit();
        }else
            System.out.println("\n=== Неправильный ввод! ===\n");
            backToViewMenu();
    }

    public static void getRegistration() {
        String myFullName;
        String myPassword;
        String myLogin;
        System.out.println("=== SeventyFly's System ===\n");
        System.out.println("Приветствуем, Вас, гость!\n\nЧтобы зарегистрироваться введите ваше имя и пароль!\n");
        System.out.print("Введите ваше полное ФИО: ");
        myFullName = yourMenuCh.nextLine();
        System.out.print("Введите ваш желаемый логин: ");
        myLogin = yourMenuCh.next();
        System.out.print("Введи свой желаемый пароль: ");
        myPassword = yourMenuCh.next();
        ClientDB.newClient(myFullName, myPassword, myLogin);
        System.out.println("\n===== Добро пожаловать, " + myFullName + "! =====\n");
        System.out.println("Сейчас Вы будете перенаправлены на страницу авторизации..");
        try {
            TimeUnit.SECONDS.sleep(3);
            getStart();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void getRules() {
        System.out.println("\n========   SeventyFly's System   ========");
        System.out.println("=====   Самая популярная система   ======");
        System.out.println("=====   Снимаем лишь 3% от суммы   ======");
        System.out.println("========   Приятно оформленна   =========");
        System.out.println("==========   Работаем 24/7   ============");
        System.out.println("========   Спасибо за доверие   =========");
        System.out.println("=============  Удачи Вам!  ==============\n");
        backToViewMenu();
    }

    public static void getIncorrectStartView() {
        System.out.println("=== SeventyFly's System ===\n");
        System.out.println("Приветствуем, Вас, гость!\n");
        System.out.println("1. Войти в систему.");
        System.out.println("2. Узнать больше о нашей системе.");
        System.out.println("3. Зарегистрироваться.");
        System.out.println("4. Выйти\n");
        System.out.println("=== Вы ввели неправильную цифру, попробуйте еще раз внимательно! ===\n");
        System.out.print("Пожалуйста, сделайте Ваш выбор: ");
        yourMenuChoice = getDouble();
        if(yourMenuChoice == 1){
            getStart();
        }
        if(yourMenuChoice == 2){
            getRules();
        }
        if(yourMenuChoice == 3){
            getRegistration();
        }
        if(yourMenuChoice == 4){
            myExit();
        }else{
            getIncorrectStartView();
        }
    }

    public static void startView() {
        System.out.println("=== SeventyFly's System ===\n");
        System.out.println("Приветствуем, Вас, гость!\n");
        System.out.println("1. Войти в систему.");
        System.out.println("2. Узнать больше о нашей системе.");
        System.out.println("3. Зарегистрироваться.");
        System.out.println("4. Выйти\n");
        System.out.print("Пожалуйста, сделайте Ваш выбор: ");
        yourMenuChoice = getDouble();
        if(yourMenuChoice == 1){
            getStart();
        }
        if(yourMenuChoice == 2){
            getRules();
        }
        if(yourMenuChoice == 3){
            getRegistration();
        }
        if(yourMenuChoice == 4){
            myExit();
        }else{
            getIncorrectStartView();
        }
    }

    private static String format ( double value )
    {
        return NumberFormat.getInstance ().format ( value ) ;
    }

    public static void getIncorrectMenu() {
        List<String> fullNameList = ClientDB.findFullName();
        System.out.println("\n=== SeventyFly's System ===\n");
        System.out.println("Здравствуйте, " + fullNameList.get(indeficatorClient) + "!\n");
        System.out.println("1. Проверить свой баланс.");
        System.out.println("2. Засчитать деньги на свой банковский счет.");
        System.out.println("3. Снять деньги с своего банковского счета.");
        System.out.println("4. Выйти.\n");
        System.out.println("=== Вы ввели неправильную цифру, попробуйте еще раз внимательно! ===\n");
        System.out.print("Пожалуйста, сделайте Ваш выбор: ");
        yourMenuChoice = getDouble();
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
            getIncorrectMenu();
        }
    }

    public static void backToMenu() {
        System.out.println("=== Вернуться в главное меню? ===\n\n1 - Да, пожалуйста!\n2 - Нет, спасибо!\n");
        System.out.print("Пожалуйста, сделайте Ваш выбор: ");
        yourMenuChoice = getDouble();
        if (yourMenuChoice == 1) {
            getMenu();
        }
        if (yourMenuChoice == 2) {
            myExit();
        }else
            System.out.println("\n=== Неправильный ввод! ===\n");
            backToMenu();
    }

    public static void incorrectInput(){
        System.out.println("=== Хотите попробывать еще раз? ===\n\n1 - Да, пожалуйста!\n2 - Нет, спасибо!\n");
        System.out.print("Пожалуйста, сделайте Ваш выбор: ");
        yourMenuChoice = getDouble();
        if (yourMenuChoice == 1) {
            getStart();
        }
        if (yourMenuChoice == 2){
            myExit();
        }else{
            System.out.println("\n=== Неправильный ввод! ===\n");
            incorrectInput();
        }
    }

    public static Double getDouble() {
        Scanner in = new Scanner(System.in);
        String s = null;
        Pattern p = Pattern.compile("^\\d+$");
        Matcher m = null;

        do
        {
            s = in.nextLine();
            m = p.matcher(s);
        } while(!m.matches());

        return Double.parseDouble(s);
    }

   public static void getStart() {
       List<String> loginList = ClientDB.findLogin();
       List<String> pwList = ClientDB.findPW();
       List<String> fullNameList = ClientDB.findFullName();
       List<Integer> idList = ClientDB.findID();
       String myLogin;
       String myPassword;
       System.out.println("\n=== SeventyFly's System ===\n");
       System.out.println("Введите пожалуйста свои данные для допуска в систему!\n");
       System.out.print("Введи свой LOGIN: ");
       myLogin = yourMenuCh.next();
       System.out.print("Введи свой PASSWORD: ");
       myPassword = yourMenuCh.next();
           for (int i = 0; i < idList.size(); i++) {
               System.out.println("\nПровірка відношення логінів до паролей: \n" + loginList.get(i) +     " " + pwList.get(i)); // провірка ліста(чи співпадає все з датабазою)
                   ind = idList.get(i);
               while (myLogin.equals(loginList.get(i)) && myPassword.equals(pwList.get(i))) {
                   System.out.println("\nВсе верно, добро пожаловать, " + fullNameList.get(i) + "..\n");
                   indeficatorClient = i;
                   try {
                       TimeUnit.SECONDS.sleep(3);
                       getMenu();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
       }
       if (!myLogin.equals(loginList.get(indeficatorClient)) && !myPassword.equals(pwList.get(indeficatorClient))) {
           System.out.println("\n=== Неверный LOGIN или PASSWORD! ===\n");
           incorrectInput();
       }else{
           System.out.println("\n=== Неверный LOGIN или PASSWORD! ===\n");
           incorrectInput();
       }
   }

    public static void getMenu() {
        List<String> fullNameList = ClientDB.findFullName();
        System.out.println("\n=== SeventyFly's System ===\n");
        System.out.println("Здравствуйте, " + fullNameList.get(indeficatorClient) + "!\n");
        System.out.println("1. Проверить свой баланс.");
        System.out.println("2. Засчитать деньги на свой банковский счет.");
        System.out.println("3. Снять деньги с своего банковского счета.");
        System.out.println("4. Выйти.\n");
        System.out.print("Пожалуйста, сделайте Ваш выбор: ");
        yourMenuChoice = getDouble();
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
           getIncorrectMenu();
        }
    }

    public static void myBalance() {
        List<Integer> cashList = ClientDB.findCash();
        System.out.println("\n=== SeventyFly's System ===\n");
        System.out.println("Ваш текущий баланс: " + cashList.get(indeficatorClient) + " грн.\n");
        backToMenu();
    }

    public static void addMoney() {
        double calculate;
        List<Integer> cashList = ClientDB.findCash();
        System.out.println("\n=== SeventyFly's System ===\n");
        newPlusCash = cashList.get(indeficatorClient);
        System.out.println("Напоминаем, что процент нашей системы 3% от суммы.\n");
        System.out.print("Введите, пожалуйста, Вашу суму которою хотите засчитать на счет: ");
        calculate = getDouble();
        if (calculate == 0) {
            System.out.println("\nВы не можете засчитать 0 грн на счет!\n");
            backToMenu();
        } else {
            bankCash = (calculate * 3/100);
            calculate = calculate - bankCash;
            calculate += cashList.get(indeficatorClient);
            ClientDB.setBankCash(bankCash, 1);
            ClientDB.setCash(calculate, ind);
            double addedCash = calculate - newPlusCash;
            System.out.println("\nВы успешно добавили на свой банковский счет: " + format (addedCash) + " грн!\n");
            System.out.println("С вас было снято коммисию в 3 процента: " + bankCash + " грн!");
            System.out.println("Ваш текущий баланс счета: " + format (calculate) + " грн!\n");
            backToMenu();
        }
    }

    public static void wdMoney() {
        double calculateMinus;
        List<Integer> cashList = ClientDB.findCash();
        System.out.println("\n=== SeventyFly's System ===\n");
        newMinusCash = cashList.get(indeficatorClient);
        System.out.println("Напоминаем, что процент нашей системы 3% от суммы.\n");
        System.out.print("Введите, пожалуйста, Вашу суму которою хотите снять с вашего счета: ");
        calculateMinus = getDouble();
        if (newMinusCash <= calculateMinus) {
            System.out.println("\nУ вас недостаточно средств на счету или Вы пытаетесь снять 0 грн!\n");
            backToMenu();
        }else {
            bankCash = (calculateMinus * 3/100);
            calculateMinus = calculateMinus - bankCash;
            calculateMinus = cashList.get(indeficatorClient) - calculateMinus;
            ClientDB.setBankCash(bankCash, 1);
            ClientDB.setMinusCash(calculateMinus, ind);
            double minusCash = newMinusCash - calculateMinus;
            System.out.println("\nВы успешно сняли с своего банковского счета: " + format (Math.abs(minusCash)) + " грн!\n");
            System.out.println("С вас было снято коммисию в 3 процента: " + bankCash + " грн!");
            System.out.println("Ваш текущий баланс счета: " + format(calculateMinus) + " грн!\n");
            backToMenu();
        }
    }
    public static void myExit() {
        System.out.println("\n=== SeventyFly's System ===\n");
        System.out.println("Спасибо, что доверяете нашей системе!");
        System.out.println("\n=== SeventyFly's System ===");
        System.exit(0);

    }

    public static void main(String[] args) {
        ClientDB clientDB = new ClientDB("jdbc:mysql://localhost:3306/banking", "root", "102030");

        startView();

        clientDB.closeConnection();
    }
}