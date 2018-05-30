package com;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDB {

    private static Connection connection;

    private static PreparedStatement preparedStatement;

    ClientDB (String url, String username, String password) {
        try {
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable() {
        try {
            this.preparedStatement = connection.prepareStatement("create table if not exists Clients(id int primary key auto_increment, fullname varchar(40), cash INT, password VARCHAR(40) );");
            this.preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void newClient(String fullname, String password, String login) {
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO clients (fullname, password, login) VALUES (?, ?, ?);");
            preparedStatement.setString(1, fullname);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, login);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void setBankCash(double bankCash, int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE bankcash SET money = money + ? WHERE id = ?");
            preparedStatement.setDouble(1, bankCash);
            preparedStatement.setInt(2, id);
            int result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void setCash(double calculate, int ind) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE clients SET cash = ? WHERE id = ?");
            preparedStatement.setDouble(1, calculate);
            preparedStatement.setInt(2, ind);
            int result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void setMinusCash(double calculateMinus, int ind) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE clients SET cash = ? WHERE id = ?");
            preparedStatement.setDouble(1, calculateMinus);
            preparedStatement.setInt(2, ind);
            int result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public static List<String> findLogin(){
        List<String>loginList = new ArrayList<>();
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("select login from clients");
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while(resultSet.next()){
                loginList.add(resultSet.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loginList;
    }

    public static List<Client> findAllClients(){
        List<Client>clientList = new ArrayList<>();
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("select * from clients");
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while(resultSet.next()){
                clientList.add( new Client(resultSet.getInt(1),resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4), resultSet.getString(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientList;
    }
    public static List<Integer> findID(){
        List<Integer>idList = new ArrayList<>();
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("select id from clients");
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while(resultSet.next()){
                idList.add(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idList;
    }

    public static List<String> findPW(){
        List<String>pwList = new ArrayList<>();
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("select password from clients");
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while(resultSet.next()){
                pwList.add(resultSet.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pwList;
    }

    public static List<String> findFullName(){
        List<String>fullNameList = new ArrayList<>();
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("select fullName from clients");
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while(resultSet.next()){
                fullNameList.add(resultSet.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fullNameList;
    }

    public static List<Integer> findCash(){
        List<Integer>cashList = new ArrayList<>();
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("select cash from clients");
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while(resultSet.next()){
                cashList.add(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cashList;
    }
}
