
import java.util.Scanner;

public class menucreater {

    Scanner ler = new Scanner(System.in);
       static int menu;
        static int clientes;

        static int totalClientes = 0;

     static String[][] lista = new String[10][8];

     static String[] campos = {
        "Código", "Nome", "CPF/CNPJ", "Data de nascimento",
        "Sexo", "Cidade", "Estado", "Status"

     };

     static int totalContatos = 0;


    static String[][] contatos = new String[10][5];

    static String[] camposContatos = {
        "Código", "cliente", "Tipo", "valor", "Status"
     };

     static int qtdclientes = 0;
     static int qtdcontatos = 0;

     static void CarregarDadosTeste() {
        String[][] dadosTeste = {
            {"1", "João Silva", "123.456.789-00", "01/01/1990", "M", "São Paulo", "SP", "Ativo"},
            {"2", "Maria Souza", "987.654.321-00", "15/05/1985", "F", "Rio de Janeiro", "RJ", "Ativo"},
            {"3", "Empresa XYZ Ltda.", "12.345.678-99", "06/06/2000", "F", "Belo Horizonte", "MG", "Inativo"},
            {"4", "Paola Souza", "sem informacao", "sem informacao", "F", "São Paulo", "SP", "inativo"}
        };

        System.out.println("\n######## ESSE TESTE NÃO CONTA COMO CLIENTE SÃO 4 FIXOS ########");

        System.out.println("Carregando dados de teste...");

        System.out.printf(
            "%-8s | %-18s | %-12s | %-20s | %-6s | %-15s | %-7s | %-10s%n",
            dadosTeste[0][0], dadosTeste[0][1], dadosTeste[0][2], dadosTeste[0][3],
            dadosTeste[0][4], dadosTeste[0][5], dadosTeste[0][6], dadosTeste[0][7]
        );
        
        System.out.printf(
            "%-8s | %-18s | %-12s | %-20s | %-6s | %-15s | %-7s | %-10s%n",
            dadosTeste[1][0], dadosTeste[1][1], dadosTeste[1][2], dadosTeste[1][3],
            dadosTeste[1][4], dadosTeste[1][5], dadosTeste[1][6], dadosTeste[1][7]
        );

        System.out.printf(
            "%-8s | %-18s | %-12s | %-20s | %-6s | %-15s | %-7s | %-10s%n",
            dadosTeste[2][0], dadosTeste[2][1], dadosTeste[2][2], dadosTeste[2][3],
            dadosTeste[2][4], dadosTeste[2][5], dadosTeste[2][6], dadosTeste[2][7]
        );

        System.out.printf(
            "%-8s | %-18s | %-12s | %-20s | %-6s | %-15s | %-7s | %-10s%n",
            dadosTeste[3][0], dadosTeste[3][1], dadosTeste[3][2], dadosTeste[3][3],
            dadosTeste[3][4], dadosTeste[3][5], dadosTeste[3][6], dadosTeste[3][7]
        );

    }

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);

        System.out.println("\n##### SEJA BEM VINDO #####");

        do {
            System.out.println("\nqual você quer acessar ?");

            System.out.println("#### 1- Gerencia clientes ####");
            System.out.println("#### 2- Gerencia contatos ####");
            System.out.println("#### 3- Relatórios ####");
            System.out.println("#### 4- Carregar dados de teste(CSV) ####");
            System.out.println("#### 0- sair ####");

            System.out.println("#### qual você escolhe ? ####");
            menu = ler.nextInt();

            if(menu <0 || menu>4) {
                System.out.println("#### numero incorreto ####");
                System.out.println("\n#############");
                
            }else {
                System.out.println("#### você escolheu n: "+ menu + " ####");
            }
                    
            if(menu == 1) {
                GerenciarClientes();
            }

            if(menu == 2) {
                GerenciarContatos();
            } if(menu == 3) {
                Relatorios();
            }

            if(menu == 4) {
                CarregarDadosTeste();
            }

        }while(menu !=0);

        System.out.println("######## Obrigado Por Usar Meu Codigo ########");
        System.out.println("######## Volte Sempre ########");

    }

    


    public static void GerenciarClientes() {
        Scanner ler = new Scanner(System.in);

        do {
            System.out.println("#### 1 - Incluir cliente ####");
            System.out.println("#### 2 - Listar clientes ####");
            System.out.println("#### 3 - Consultar cliente por código ####");
            System.out.println("#### 4 - Alterar cliente ####");
            System.out.println("#### 5 - Apagar cliente ####");
            System.out.println("#### 6 - Ordenar clientes por nome ####");
            System.out.println("#### 7 - pesquisar cliente por nome ####"); 
            System.out.println("#### 0 - Voltar ####");

            System.out.println("#### qual você escolhe ? ####");
            clientes = ler.nextInt();

            if(clientes <0 || clientes>7) {
                System.out.println("#### numero incorreto ####");
                System.out.println("\n#############");
                
            }
            switch(clientes) {
                case 1:
                    IncluirCliente();
                    break;
                case 2:
                    ListarClientesTabela();
                    break;
                case 3:
                    BuscarClientePorCodigo();
                    break;
                case 4:
                    AlterarCliente();
                    break;
                case 5:
                    ApagarCliente();
                    break;
                case 6:
                    OrdenarClientesPorNome();
                    break;
                case 7:
                    PesquisarClientePorNome();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
            }

        }while(clientes !=0);
    }



    public static void IncluirCliente() {

        Scanner ler = new Scanner(System.in);

        System.out.println("#### Incluir cliente ####");

        if (totalClientes < lista.length) {

            System.out.println("\n--- Cadastrando Cliente " + (totalClientes + 1) + " ---");

            for (int col = 0; col < 8; col++) {

                System.out.print("Digite " + campos[col]);

                lista[totalClientes][col] = ler.nextLine();
            }

            totalClientes++;
            qtdclientes++;

            System.out.println("Cliente cadastrado com sucesso!");

        } else {

            System.out.println("Limite máximo de 10 clientes atingido!");
            aumentarMatrizClientes();
        }
    }

    public static void ListarClientesTabela() {

        System.out.println("\n######## LISTAR OS CLIENTES ########");

    if (totalClientes == 0) {

        System.out.println("Nenhum cliente cadastrado ainda.");

    } else {

        System.out.printf(
            "%-8s | %-18s | %-12s | %-20s | %-6s | %-15s | %-7s | %-10s%n",
            campos[0], campos[1], campos[2], campos[3],
            campos[4], campos[5], campos[6], campos[7]
        );

        System.out.println("---------------------------------------------------------------------------------------------------------------");

        for (int lin = 0; lin < totalClientes; lin++) {
            System.out.printf(
                "%-8s | %-18s | %-12s | %-20s | %-6s | %-15s | %-7s | %-10s%n",
                lista[lin][0],
                lista[lin][1],
                lista[lin][2],
                lista[lin][3],
                lista[lin][4],
                lista[lin][5],
                lista[lin][6],
                lista[lin][7]
            );
            System.out.println("---------------------------------------------------------------------------------------------------------------\n");
          }
        }
    }

   public static void BuscarClientePorCodigo() {

    Scanner ler = new Scanner(System.in);

    System.out.println("\n######## BUSCAR CLIENTE ########");

    System.out.print("\nDigite o código do cliente: ");
    String codigo = ler.nextLine();

    boolean encontrado = false;

    for (int lin = 0; lin < totalClientes; lin++) {

        if (lista[lin][0].equals(codigo)) {

            System.out.println("\n######## CLIENTE ENCONTRADO ########");

            System.out.printf(
                "%-8s | %-18s | %-12s | %-20s | %-6s | %-15s | %-7s | %-10s%n",
                campos[0], campos[1], campos[2], campos[3],
                campos[4], campos[5], campos[6], campos[7]
            );

            System.out.println("---------------------------------------------------------------------------------------------------------------");

            System.out.printf(
                "%-8s | %-18s | %-12s | %-20s | %-6s | %-15s | %-7s | %-10s%n",
                lista[lin][0],
                lista[lin][1],
                lista[lin][2],
                lista[lin][3],
                lista[lin][4],
                lista[lin][5],
                lista[lin][6],
                lista[lin][7]
            );

            encontrado = true;

            break;
        }
    }

    if (!encontrado) {
        System.out.println("Cliente não encontrado.");
    }
    System.out.println("---------------------------------------------------------------------------------------------------------------");
  }

  public static void AlterarCliente() {
    Scanner ler = new Scanner(System.in);

 System.out.println("\n######## ALTERAR CLIENTE ########");

 ListarClientesTabela();

    System.out.print("\nDigite o código do cliente que deseja alterar: ");
    String codigo = ler.nextLine();

    System.out.println("Você deseja alterar o cliente com código(S ou N): " + codigo);
    String confirmacao = ler.nextLine();

    if (!confirmacao.equalsIgnoreCase("S")) {
        System.out.println("Alteração cancelada.");
        return;
    }

    boolean encontrado = false;

    for (int lin = 0; lin < totalClientes; lin++) {

        if (lista[lin][0].equals(codigo)) {

            System.out.println("\n######## CLIENTE ENCONTRADO ########");

            for (int col = 1; col < 8; col++) {
                System.out.print("Digite novo " + campos[col] + " (atual: " + lista[lin][col] + "): ");
                String novoValor = ler.nextLine();
                if (!novoValor.isEmpty()) {
                    lista[lin][col] = novoValor;
                }
            }

            System.out.println("Cliente alterado com sucesso!");
            encontrado = true;
            break;
        }
    }

    if (!encontrado) {
        System.out.println("Cliente não encontrado.");
    }

  }

 public static void ApagarCliente() {
    Scanner ler = new Scanner(System.in);

    System.out.println("\n######## APAGAR CLIENTE ########");

    ListarClientesTabela();

    System.out.print("\nDigite o código do cliente que deseja apagar: ");
    String codigo = ler.nextLine();

    System.out.println("Você deseja apagar o cliente com código(S ou N): " + codigo);
    String confirmacao = ler.nextLine();

    if (!confirmacao.equalsIgnoreCase("S")) {
        System.out.println("Exclusão cancelada.");
        return;
    }

    boolean encontrado = false;

    for (int lin = 0; lin < totalClientes; lin++) {

        if (lista[lin][0].equals(codigo)) {
        
            for (int i = lin; i < totalClientes - 1; i++) {
                lista[i] = lista[i + 1];
            }

            lista[totalClientes - 1] = new String[8];

            totalClientes--;
            qtdclientes--;
            System.out.println("Cliente apagado com sucesso!");
            encontrado = true;
            break;
        }
    }

    if (!encontrado) {
        System.out.println("Cliente não encontrado.");
    }
  }

  public static void OrdenarClientesPorNome() {

    if (totalClientes == 0) {
        System.out.println("Nenhum cliente cadastrado para ordenar.");
        return;
    }

    for (int i = 0; i < totalClientes - 1; i++) {

        for (int j = 0; j < totalClientes - i - 1; j++) {

            if (lista[j][1].compareToIgnoreCase(lista[j + 1][1]) > 0) {

                String[] temp = lista[j];

                lista[j] = lista[j + 1];

                lista[j + 1] = temp;
            }
        }
    }

    System.out.println("Clientes ordenados por nome com sucesso!");

    ListarClientesTabela();
 }


  public static void GerenciarContatos() {
  Scanner ler = new Scanner(System.in);


                do{
                    System.out.println("#### 1 - Incluir contato ####");
                    System.out.println("#### 2 - Listar contatos (todos os clientes)  ####");
                    System.out.println("#### 3 - Consultar contato de um cliente ####");
                    System.out.println("#### 4 - Alterar contato  ####");
                    System.out.println("#### 5 - Apagar contato  ####");
                    System.out.println("#### 6 - Listar contato por tipo ####");
                    System.out.println("#### 0 - Voltar  ####");

                    System.out.println("#### qual você escolhe ? ####");
                    clientes = ler.nextInt();

                    if(clientes <0 || clientes>7) {
                        System.out.println("#### numero incorreto ####");
                        System.out.println("\n#############");
                        
                    }
                    switch(clientes) {
                        case 1:
                            IncluirContato();
                            break;
                        case 2:
                            ListarContatosTabela();
                            break;
                        case 3:
                            ListarContatoPorCodigo();
                            break;
                        case 4:
                            AlterarContato();
                            break;
                        case 5:
                            ApagarContato();
                            break;
                        case 7:
                            PesquisarClientePorNome();
                            break;
                        case 0:
                            System.out.println("Voltando ao menu principal...");
                            break;
                    }

                }while(clientes !=0);
            }

            public static void IncluirContato() {
                Scanner ler = new Scanner(System.in);

                System.out.println("####### Incluir contato ########");

                System.out.print("Digite o código do cliente para o qual deseja adicionar um contato: ");
                String codigoCliente = ler.nextLine();

                for(int lin = 0; lin < lista.length; lin++) {

                    if (lista[lin][0].equals(codigoCliente)) {

                        if (totalContatos < contatos.length) {

                            System.out.println("\n--- Cadastrando Contato " + (totalContatos + 1) + " ---");

                            for (int col = 0; col < 5; col++) {
                                System.out.print("Digite " + camposContatos[col]);
                                contatos[totalContatos][col] = ler.nextLine();
                            }

                            totalContatos++;
                            qtdcontatos++;

                            System.out.println("Contato cadastrado com sucesso!");

                        } else {
                            System.out.println("Limite máximo de contatos atingido!");
                            aumentarMatrizContatos();
                        }
                        return;
                    }
                }
                System.out.println("Cliente não encontrado!");
            }

            public static void ListarContatosTabela() {

                Scanner ler = new Scanner(System.in);

                System.out.println("\n######## LISTAR OS CONTATOS ########");

                for(int i = 0; i < totalContatos; i++) {
                    System.out.printf(
                        "%-8s | %-18s | %-12s | %-20s | %-6s%n",
                        camposContatos[0], camposContatos[1], camposContatos[2], camposContatos[3], camposContatos[4]
                    );
                    System.out.println("-------------------------------------------------------------");

                    System.out.printf(
                        "%-8s | %-18s | %-12s | %-20s | %-6s%n",
                        contatos[i][0], contatos[i][1], contatos[i][2], contatos[i][3], contatos[i][4]
                    );
                    System.out.println("-------------------------------------------------------------");
                }
            }

            public static void ListarContatoPorCodigo() {
                Scanner ler = new Scanner(System.in);

                System.out.println("\n######## CONSULTAR CONTATO ########");
                System.out.print("\nDigite o código do contato: ");
                String codigo = ler.nextLine();

                for (int i = 0; i < totalContatos; i++) {

                    if (contatos[i][0].equals(codigo)) {

                        System.out.printf(
                            "%-8s | %-18s | %-12s | %-20s | %-6s%n",
                            camposContatos[0], camposContatos[1], camposContatos[2], camposContatos[3], camposContatos[4]
                        );
                        System.out.println("-------------------------------------------------------------");
                        System.out.printf(
                            "%-8s | %-18s | %-12s | %-20s | %-6s%n",
                            contatos[i][0], contatos[i][1], contatos[i][2], contatos[i][3], contatos[i][4]
                        );
                        return;
                    }
                }
                System.out.println("Contato não encontrado!");
            }

            public static void AlterarContato() {
                
                Scanner ler = new Scanner(System.in);
                
                System.out.println("\n######## ALTERAR CONTATO ########");

                ListarContatosTabela();

                System.out.print("\nDigite o código do contato que deseja alterar: ");
                String codigo = ler.nextLine();

                System.out.println("Você deseja alterar o contato com código(S ou N): " + codigo);
                String confirmacao = ler.nextLine();

                if (!confirmacao.equalsIgnoreCase("S")) {
                    System.out.println("Alteração cancelada.");
                    return;
                }

                for (int i = 0; i < totalContatos; i++) {

                    if (contatos[i][0].equals(codigo)) {

                        System.out.println("\n######## CONTATO ENCONTRADO ########");
                        for (int col = 1; col < 5; col++) {

                            System.out.print("Digite novo " + camposContatos[col] + " (atual: " + contatos[i][col] + "): ");
                            String novoValor = ler.nextLine();

                            if (!novoValor.isEmpty()) {
                                contatos[i][col] = novoValor;
                            }
                        }
                        System.out.println("Contato alterado com sucesso!");
                        return;
                    }
                }
                System.out.println("Contato não encontrado!");
                ler.close();
            }

            public static void ApagarContato() {
                Scanner ler = new Scanner(System.in);

                System.out.println("\n######## APAGAR CONTATO ########");

                ListarContatosTabela();

                System.out.print("\nDigite o código do contato que deseja apagar: ");
                String codigo = ler.nextLine();

                System.out.println("Você deseja apagar o contato com código(S ou N): " + codigo);
                String confirmacao = ler.nextLine();

                if (!confirmacao.equalsIgnoreCase("S")) {
                    System.out.println("Exclusão cancelada.");
                    ler.close();
                    return;
                }

                for (int i = 0; i < totalContatos; i++) {
                    if (contatos[i][0].equals(codigo)) {
                        qtdcontatos--;
                        for (int j = 0; j < 5; j++) {
                            contatos[i][j] = "";
                        }
                        System.out.println("Contato apagado com sucesso!");
                        return;
                    }
                }
                System.out.println("Contato não encontrado!");
                ler.close();
            }

            public static void ListarContatosPorTipo() {
                Scanner ler = new Scanner(System.in);

                System.out.println("\n######## LISTAR CONTATOS POR TIPO ########");

                ListarContatosTabela();

                System.out.print("\nDigite o tipo de contato que deseja listar: ");
                String tipoPesquisa = ler.nextLine();

                boolean encontrado = false;

                for (int i = 0; i < totalContatos; i++) {

                    if (contatos[i][2].equalsIgnoreCase(tipoPesquisa)) {

                        System.out.printf(
                            "%-8s | %-18s | %-12s | %-20s | %-6s%n",
                            camposContatos[0], camposContatos[1], camposContatos[2], camposContatos[3], camposContatos[4]
                        );
                        System.out.println("-------------------------------------------------------------");
                        System.out.printf(
                            "%-8s | %-18s | %-12s | %-20s | %-6s%n",
                            contatos[i][0], contatos[i][1], contatos[i][2], contatos[i][3], contatos[i][4]
                        );
                        encontrado = true;
                    }
                }

                if (!encontrado) {
                    System.out.println("Nenhum contato encontrado com o tipo informado.");
                }
            }

            public static void PesquisarClientePorNome() {
                Scanner ler = new Scanner(System.in);

                System.out.println("\n######## PESQUISAR CLIENTE POR NOME ########");

                ListarClientesTabela();

                System.out.print("\nDigite o nome do cliente que deseja pesquisar: ");
                String nomePesquisa = ler.nextLine();

                boolean encontrado = false;

                for (int lin = 0; lin < totalClientes; lin++) {

                    if (lista[lin][1].toLowerCase().contains(nomePesquisa.toLowerCase())) {

                        System.out.printf(
                            "%-8s | %-18s | %-12s | %-20s | %-6s | %-15s | %-7s | %-10s%n",
                            campos[0], campos[1], campos[2], campos[3],
                            campos[4], campos[5], campos[6], campos[7]
                        );

                        System.out.println("---------------------------------------------------------------------------------------------------------------");

                        System.out.printf(
                            "%-8s | %-18s | %-12s | %-20s | %-6s | %-15s | %-7s | %-10s%n",
                            lista[lin][0],
                            lista[lin][1],
                            lista[lin][2],
                            lista[lin][3],
                            lista[lin][4],
                            lista[lin][5],
                            lista[lin][6],
                            lista[lin][7]
                        );

                        encontrado = true;
                    }
                }

                if (!encontrado) {
                    System.out.println("Nenhum cliente encontrado com o nome informado.");
                }
            }

            public static void Relatorios() {
                System.out.println("\n######## RELATÓRIOS ########");
                int mediaclientescontatos = 0;
                int clietessemcontatos = 0;
                    mediaclientescontatos = qtdcontatos / qtdclientes;
                    clietessemcontatos = qtdclientes - qtdcontatos;
                      
                    System.out.println("Quantidade de clientes cadastrados: " + qtdclientes);
                    System.out.println("Quantidade de contatos cadastrados: " + qtdcontatos);
                    System.out.println("Média de contatos por cliente: " + mediaclientescontatos);
                    System.out.println("Quantidade de clientes sem contatos: " + clietessemcontatos);
                 
            }

            public static void aumentarMatrizClientes() {
                String[][] novaLista = new String[lista.length * 2][8];
                for (int i = 0; i < lista.length; i++) {
                    for (int j = 0; j < 8; j++) {
                        novaLista[i][j] = lista[i][j];
                    }
                }
                lista = novaLista;
            }

            public static void aumentarMatrizContatos() {
                String[][] novaLista = new String[contatos.length * 2][5];
                for (int i = 0; i < contatos.length; i++) {
                    for (int j = 0; j < 5; j++) {
                        novaLista[i][j] = contatos[i][j];
                    }
                }
                contatos = novaLista;
            }

        }


