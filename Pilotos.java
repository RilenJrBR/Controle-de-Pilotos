package aplicativos;

public class Pilotos {

    private String nome;
    private String cpf;
     
    public Pilotos(){  
    }
   
    public String getNome(){
        return nome;
    }
   
   public void setNome(String name){
        this.nome = name;
    }
      
    public String getCpf(){
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
        
    }
}