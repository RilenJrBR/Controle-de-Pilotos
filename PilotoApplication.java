package aplicativos;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class AppPilotos {
   	    public static void main(String[] args) throws InterruptedException, IOException {
        int MAX_ELEMENTOS = 20;
        int opcao;
        Scanner in = new Scanner(System.in);
        List<Pilotos> pilotosList = new ArrayList<Pilotos>(MAX_ELEMENTOS); 

        do {
            System.out.println("\n*\nMENU\n*\n");
            System.out.println("1 - Cadastrar piloto");
            System.out.println("2 - Listar pilotos cadastrados");
            System.out.println("3 - Localizar piloto pelo CPF");
            System.out.println("4 - Aumentar espaço de armazenamento");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = in.nextInt();
            in.nextLine(); 

            if (opcao == 1) {
                
                if (pilotosList.size() == MAX_ELEMENTOS) { 
                    System.out.println("\nNão há espaço para cadastrar novos pilotos.");
                    voltarMenu(in);
                    continue;
                }

                Pilotos piloto = new  Pilotos();

                System.out.println("Digite o Nome do Piloto:");
                piloto.setNome(in.nextLine());

                System.out.print("Digite o CPF do Piloto:\n");
                piloto.setCpf(in.nextLine());  
                
                System.out.println("Digitie 1 para confirmar cadastro ou 0 para voltar ao menu");
                    if(in.nextInt() == 1) {

                        pilotosList.add(piloto);

                        System.out.printf("\nPiloto cadastrado com sucesso.");
                    } else {
                      System.out.printf("\nCadastro cancelado.");
                    }
                
                
                voltarMenu(in);
            } else if (opcao == 2) {

                System.out.printf("Pilotos cadastrados\n");

                for (int i = 0; i < pilotosList.size(); i++) {
                Pilotos piloto = pilotosList.get(i);
                System.out.printf("Piloto %d - %s CPF= %s\n", i, piloto.getNome(), piloto.getCpf());
                }

                if (pilotosList.isEmpty()) { 
                    System.out.printf("\nNão há Pilotos cadastrados para exibir.");
                    voltarMenu(in);
                    continue;
                }               

                voltarMenu(in);
            } else if (opcao == 3) {

                if(pilotosList.isEmpty()) {
                  System.out.printf("\nNenhum piloto cadastrado no momento");

                } else { 
                  
                  System.out.println("\nInforme o CPF do Piloto que esta buscando:\n");
                  String cpf = in.nextLine();
                  for(int i = 0; i < pilotosList.size(); i++) {
                    Pilotos piloto = pilotosList.get(i);
                    if(piloto.getCpf().equals(cpf)) {
                        System.out.printf("Piloto %s: ", piloto.getNome());
                      break;
                    }else{
                        System.out.println("\nPiloto não encontrado na base de dados:\n");

                    }
                  }
                }
                voltarMenu(in);

            } else if (opcao == 4) {

                
                System.out.println("Digite o do Volume que deseja:");
                int vol = in.nextInt();

                if(vol < pilotosList.size()) {
                    String ler;
                    System.out.println("O novo volume é inferior a quantidade de pilotos cadastrados. Essa ação vai descartar alguns registros. Deseja continuar? (S) Sim (N) Não");
                    ler = in.nextLine();
                    if(in.nextLine().equalsIgnoreCase(ler)) {
                        for (int i = pilotosList.size() - 1; i >= vol; i--) {
                            pilotosList.remove(i);
                        }
                        MAX_ELEMENTOS = vol;
                    }
                } else {
                    MAX_ELEMENTOS = vol;
                }
                        
                voltarMenu(in);
            }else if (opcao != 0) {
                System.out.println("\nOpção inválida!");
            }
        } while (opcao != 0);

        System.out.println("Fim do programa!");

        in.close();
    }

    
    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        // Limpa toda a tela, deixando novamente apenas o menu
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");
        
        System.out.flush();
    }
}