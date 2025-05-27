package br.com.marcelo.vacancy_management.exceptions;

public class CompanyFoundException extends RuntimeException{
    public CompanyFoundException(){
        super("A empresa ja existe");
    }
}
