package br.lamao.tdd.ex2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonDAOTest {

    PersonDAO dao = new PersonDAO();

    @Test
    void deveValidarPessoaValida() {
        List<Email> emails = List.of(new Email(1, "teste@email.com"));
        Person p = new Person(1, "Joao Silva", 30, emails);
        List<String> erros = dao.isValidToInclude(p);
        assertTrue(erros.isEmpty());
    }

    @Test
    void deveDetectarNomeComNumerosEMaisDeUmaParte() {
        Person p = new Person(1, "Joao123 Silva", 30, List.of(new Email(1, "teste@email.com")));
        List<String> erros = dao.isValidToInclude(p);
        assertTrue(erros.stream().anyMatch(e -> e.contains("Nome inválido")));
    }

    @Test
    void deveDetectarNomeComUmaUnicaParte() {
        Person p = new Person(1, "Joao", 30, List.of(new Email(1, "teste@email.com")));
        List<String> erros = dao.isValidToInclude(p);
        assertTrue(erros.stream().anyMatch(e -> e.contains("Nome inválido")));
    }

    @Test
    void deveDetectarNomeComEspacosMasNaoLetras() {
        Person p = new Person(1, "123 456", 30, List.of(new Email(1, "teste@email.com")));
        List<String> erros = dao.isValidToInclude(p);
        assertTrue(erros.stream().anyMatch(e -> e.contains("Nome inválido")));
    }

    @Test
    void deveDetectarIdadeInvalidaBaixa() {
        Person p = new Person(1, "Joao Silva", 0, List.of(new Email(1, "teste@email.com")));
        List<String> erros = dao.isValidToInclude(p);
        assertTrue(erros.stream().anyMatch(e -> e.contains("Idade inválida")));
    }

    @Test
    void deveDetectarIdadeInvalidaAlta() {
        Person p = new Person(1, "Joao Silva", 300, List.of(new Email(1, "teste@email.com")));
        List<String> erros = dao.isValidToInclude(p);
        assertTrue(erros.stream().anyMatch(e -> e.contains("Idade inválida")));
    }

    @Test
    void deveDetectarEmailsNull() {
        Person p = new Person(1, "Joao Silva", 30, null);
        List<String> erros = dao.isValidToInclude(p);
        assertTrue(erros.stream().anyMatch(e -> e.contains("e-mail associado")));
    }

    @Test
    void deveDetectarEmailsVazios() {
        Person p = new Person(1, "Joao Silva", 30, new ArrayList<>());
        List<String> erros = dao.isValidToInclude(p);
        assertTrue(erros.stream().anyMatch(e -> e.contains("e-mail associado")));
    }

    @Test
    void deveDetectarEmailInvalido() {
        List<Email> emails = List.of(new Email(1, "emailinvalido"));
        Person p = new Person(1, "Joao Silva", 30, emails);
        List<String> erros = dao.isValidToInclude(p);
        assertTrue(erros.stream().anyMatch(e -> e.contains("E-mail inválido")));
    }

    @Test
    void deveDetectarEmailValidoEOutroInvalido() {
        List<Email> emails = List.of(
                new Email(1, "emailvalido@email.com"),
                new Email(2, "invalido")
        );
        Person p = new Person(1, "Joao Silva", 30, emails);
        List<String> erros = dao.isValidToInclude(p);
        assertTrue(erros.stream().anyMatch(e -> e.contains("E-mail inválido")));
    }

    @Test
    void deveDetectarMultiplosErros() {
        List<Email> emails = List.of(new Email(1, "semarroba"));
        Person p = new Person(1, "Joao", -5, emails);
        List<String> erros = dao.isValidToInclude(p);
        assertEquals(3, erros.size());
    }
}
