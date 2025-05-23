package CRUDFuncionario;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws SQLException {
        int op;
        do {
            op = menu();
            switch (op) {
                case 1 -> adicionaDados();
                case 2 -> alteraDados();
                case 3 -> excluiDados();
                case 4 -> exibeDados();
                case 5 -> System.out.println("Programa finalizado");
                default -> System.out.println("Opção inválida");
            }
        } while (op != 5);
    }

    public static int menu() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("1 - Incluir Funcionário");
        System.out.println("2 - Alterar Funcionário");
        System.out.println("3 - Excluir Funcionário");
        System.out.println("4 - Listar Funcionários");
        System.out.println("5 - Finalizar");
        System.out.print("Escolha sua opção: ");
        return entrada.nextInt();
    }

    public static void adicionaDados() throws SQLException {
        Scanner entrada = new Scanner(System.in);
        Funcionario f = new Funcionario();
        FuncionarioDAO dao = new FuncionarioDAO();
        try {
            System.out.print("ID: ");
            f.setIdFuncionario(entrada.nextInt());
            entrada.nextLine();
            System.out.print("Nome: ");
            f.setNome(entrada.nextLine());
            System.out.print("Cargo: ");
            f.setCargo(entrada.nextLine());
            System.out.print("Data de Admissão (YYYY-MM-DD): ");
            f.setDataAdmissao(entrada.nextLine());
            System.out.print("Salário: ");
            f.setSalario(entrada.nextDouble());
            dao.adicionar(f);
        } catch (InputMismatchException e) {
            System.out.println("Erro: tipo de dado inválido.");
        }
    }

    public static void alteraDados() throws SQLException {
        Scanner entrada = new Scanner(System.in);
        Funcionario f = new Funcionario();
        FuncionarioDAO dao = new FuncionarioDAO();
        try {
            System.out.print("ID do funcionário a alterar: ");
            f.setIdFuncionario(entrada.nextInt());
            entrada.nextLine();
            System.out.print("Novo Nome: ");
            f.setNome(entrada.nextLine());
            System.out.print("Novo Cargo: ");
            f.setCargo(entrada.nextLine());
            System.out.print("Nova Data de Admissão (YYYY-MM-DD): ");
            f.setDataAdmissao(entrada.nextLine());
            System.out.print("Novo Salário: ");
            f.setSalario(entrada.nextDouble());
            dao.alterar(f);
        } catch (InputMismatchException e) {
            System.out.println("Erro: tipo de dado inválido.");
        }
    }

    public static void excluiDados() throws SQLException {
        Scanner entrada = new Scanner(System.in);
        Funcionario f = new Funcionario();
        FuncionarioDAO dao = new FuncionarioDAO();
        System.out.print("ID do funcionário a excluir: ");
        f.setIdFuncionario(entrada.nextInt());
        dao.apagar(f);
    }

    public static void exibeDados() throws SQLException {
        FuncionarioDAO dao = new FuncionarioDAO();
        List<Funcionario> lista = dao.getLista();
        for (Funcionario f : lista) {
            System.out.println("ID: " + f.getIdFuncionario());
            System.out.println("Nome: " + f.getNome());
            System.out.println("Cargo: " + f.getCargo());
            System.out.println("Data de Admissão: " + f.getDataAdmissao());
            System.out.println("Salário: " + f.getSalario());
            System.out.println("------------------------------");
        }
    }
}