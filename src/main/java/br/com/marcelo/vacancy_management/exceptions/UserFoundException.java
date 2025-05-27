package br.com.marcelo.vacancy_management.exceptions;

public class UserFoundException extends RuntimeException{
    public UserFoundException(){
        super("Usuario ja existe");
    }
}
