package com.bitirmeprojesi.eticaret.model.env;


public enum   Environment {


     BASE_URL("http://localhost:8080");


     private String text;



     Environment(String text){
          this.text=text;
     }

     public String getText() {
          return text;
     }
}
