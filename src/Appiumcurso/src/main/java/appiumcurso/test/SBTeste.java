package appiumcurso.test;

import appiumcurso.BaseTest;
import appiumcurso.page.MenuPage;
import appiumcurso.test.page.seuBarriga.SBContasPage;
import appiumcurso.test.page.seuBarriga.SBLoginPage;
import appiumcurso.test.page.seuBarriga.SBMenuPage;
import appiumcurso.test.page.seuBarriga.SBMovimentacaoPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SBTeste extends BaseTest {
    private MenuPage menu = new MenuPage();
    private SBLoginPage login = new SBLoginPage();
    private SBContasPage contas = new SBContasPage();
    private SBMenuPage menuSB = new SBMenuPage();
    private SBMovimentacaoPage mov = new SBMovimentacaoPage();
    private SBHomePage home = new SBHomePage();
    private SBResumoPage resumo = new SBResumoPage();


    @Before
    public void setup() {
        menu.acessarSBNativo();
        login.setEmail("qateste@gmail.com");
        login.setSenha("qateste1234");
        login.entrar();

    }

    @Test
    public void test() {
        // entrar en contas
        menuSB.acesssarContas();

        // digitar nome conta
        contas.setConta("teste");
        // salvar
        contas.salvar();

        // verificar mensagem
        Assert.assertTrue(contas.existeElementoPorTexto("Conta adicionada com sucesso"));
    }

    @Test
    public void deveExcluirConta() {
        // entrar en contas
        menuSB.acesssarContas();
        // clique longo na conta
        contas.selecionarConta("teste");

        //excluir
        contas.excluir();
        //verificar mensagens

        Assert.assertTrue(contas.existeElementoPorTexto("Conta excluída com sucesso"));
    }

    @Test
    public void deveValidarInclusaoMov() {
        menuSB.acessarMovimentacoes();

        // validar desc
        mov.salvar();
        Assert.assertTrue(mov.existeElementoPorTexto("Descrição é um campo obrigatório"));

        // validar inte
        mov.setDescricao("Desc");
        mov.salvar();
        Assert.assertTrue(mov.existeElementoPorTexto("Interessado é um campo obrigatório"));

        // validar valor
        mov.setInteressado("interess");
        mov.salvar();
        Assert.assertTrue(mov.existeElementoPorTexto("Valor é um campo obrigatório"));

        //validar conta
        mov.setValor("teste");
        mov.salvar();
        Assert.assertTrue(mov.existeElementoPorTexto("Conta é um campo obrigatório"));

        // inserir com sucesso
        mov.setConta("Conta para alterar");
        mov.salvar();
        Assert.assertTrue(mov.existeElementoPorTexto("Movimentação cadastrada com sucesso!"));

    }

    @Test
    public void deveAtualizarSaldoAoExcluirMovimentacao() {

        //verificar saldo "Conta para Saldo" = 534.00
        Assert.assertEquals("534.00", home.obterSaldoConta("Conta para saldo"));

        // ir para resumo
        menuSB.acessarResumo();

        // excluir Movimentacao 3
        resumo.excluirMovimentacao("Movimentacao 3, calculo saldo");

        // validar a mensagem "Movimentação removida com sucesso "
        Assert.assertTrue(resumo.existeElementoPorTexto("Movimentação removida com sucesso!"));

        // voltar home
        menuSB.acessarHome();

        // atualizar saldo
        esperar(1000);
        home.scroll(0.2,0.9);

        //verificar saldo -1000.00
        Assert.assertEquals("-1000.00", home.obterSaldoConta("Conta para saldo"));

    }


}
