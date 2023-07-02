//        LivroReceitasService livroService = new LivroReceitasService();
//
//        LivroReceitas livro = new LivroReceitas(1, "Meu Livro de Receitas");
//
//        livroService.adicionarLivroReceitas(livro);

//        Igredientes igredientes = new Igredientes();
//        igredientes.setId(1);
//        igredientes.setNome("Farinha");
//        igredientes.setQuantidade("250");
//        igredientes.setUnidadeMedida("gramas");
//
//        IgredientesService igredientesService = new IgredientesService();
//
//        igredientesService.adicionarIgredientes(igredientes);

//        ModoPreparoService modoPreparoService = new ModoPreparoService();
//
//        ModoPreparo modoPreparo = new ModoPreparo();
//        modoPreparo.setId(1);
//        modoPreparo.setOrdem("Passo 1");
//        modoPreparo.setDescricao("TESTE");
//
//        modoPreparoService.createModoPreparo(modoPreparo);
//
//        System.out.println("Modo de preparo inserido com sucesso!");
//
//        ReceitasService receitasService = new ReceitasService();
//
//        Receitas receita = new Receitas();
//        receita.setId(1);
//        receita.setNome("Bolo de Chocolate");
//        receita.setRendimento("8 porções");
//        receita.setLocalCreateTime(LocalDateTime.now());
//        receita.setCategoria(Categoria.DOCE);
//
//        receitasService.adicionarReceita(receita);
//
//        System.out.println("Receita inserida com sucesso!");

import models.Categoria;
import models.LivroReceitas;
import models.ModoPreparo;
import models.Receitas;
import service.LivroReceitasService;
import service.ModoPreparoService;
import service.ReceitasService;

public class Main {
    public static void main(String[] args) {
        // Inserção de Livro de Receitas
        LivroReceitasService livroReceitasService = new LivroReceitasService();

        LivroReceitas livroReceitas = new LivroReceitas();
        livroReceitas.setId(1);
        livroReceitas.setNome("Livro de Receitas 1");

        livroReceitasService.adicionarLivroReceitas(livroReceitas);

        livroReceitasService.inserirLivroReceitasNoBanco();

        System.out.println("Livro de receitas inserido com sucesso!");

        // Inserção de Modo de Preparo
        ModoPreparoService modoPreparoService = new ModoPreparoService();

        ModoPreparo modoPreparo = new ModoPreparo();
        modoPreparo.setId(1);
        modoPreparo.setOrdem("Passo 1");
        modoPreparo.setDescricao("Descrição do Passo 1");

        modoPreparoService.createModoPreparo(modoPreparo);

        modoPreparoService.inserirModoPreparoNoBanco();

        System.out.println("Modo de preparo inserido com sucesso!");

        // Inserção de Receita
        ReceitasService receitasService = new ReceitasService();

        Receitas receita = new Receitas();
        receita.setId(1);
        receita.setNome("Bolo de Chocolate");
        receita.setRendimento("8 porções");
        receita.setCategoria(Categoria.DOCE);

        receitasService.adicionarReceita(receita);

        receitasService.inserirReceitaNoBanco();

        System.out.println("Receita inserida com sucesso!");
    }
}

