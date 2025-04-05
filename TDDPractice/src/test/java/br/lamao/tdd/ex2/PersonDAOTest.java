package br.lamao.tdd.ex2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonDAOTest {

    PersonDAO dao = new PersonDAO();

    @Test
    public void deveValidarPessoaValida() {
        List<Email> emails = List.of(new Email(1, "teste@email.com"));
        Person p = new Person(1, "Joao Silva", 30, emails);
        List<String> erros = dao.isValidToInclude(p);
        assertTrue(erros.isEmpty());
    }@Test
    public void deveDetectarNomeInvalido() {
        List<Email> emails = List.of(new Email(1, "teste@email.com"));
        Person p = new Person(1, "Joao123", 30, emails);
        List<String> erros = dao.isValidToInclude(p);
        assertTrue(erros.stream().anyMatch(e -> e.contains("Nome inválido")));
    }@Test
    public void deveDetectarIdadeInvalidaBaixa() {
        Person p = new Person(1, "Joao Silva", 0, List.of(new Email(1, "teste@email.com")));
        List<String> erros = dao.isValidToInclude(p);
        assertTrue(erros.stream().anyMatch(e -> e.contains("Idade inválida")));
    }@Test
    public void deveDetectarIdadeInvalidaAlta() {
        Person p = new Person(1, "Joao Silva", 300, List.of(new Email(1, "teste@email.com")));
        List<String> erros = dao.isValidToInclude(p);
        assertTrue(erros.stream().anyMatch(e -> e.contains("Idade inválida")));
    }@Test
    public void deveDetectarAusenciaDeEmail() {
        Person p = new Person(1, "Joao Silva", 30, new ArrayList<>());
        List<String> erros = dao.isValidToInclude(p);
        assertTrue(erros.stream().anyMatch(e -> e.contains("e-mail associado")));
    }@Test
    public void deveDetectarEmailInvalido() {
        List<Email> emails = List.of(new Email(1, "emailinvalido"));
        Person p = new Person(1, "Joao Silva", 30, emails);
        List<String> erros = dao.isValidToInclude(p);
        assertTrue(erros.stream().anyMatch(e -> e.contains("E-mail inválido")));
    }@Test
    public void deveDetectarMultiplosErros() {
        List<Email> emails = List.of(new Email(1, "semarroba"));
        Person p = new Person(1, "Joao", -5, emails);
        List<String> erros = dao.isValidToInclude(p);
        assertEquals(3, erros.size());
    }

}