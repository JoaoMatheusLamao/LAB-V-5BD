package br.lamao.tdd.ex1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class TrianguloTest {

@Test
public void deveIdentificarTrianguloEscaleno() {
    Triangulo triangulo = new Triangulo(3, 4, 5);
    assertTrue(triangulo.isTriangulo());
    assertEquals(TipoTriangulo.ESCALENO, triangulo.getTipo());
}

@Test
public void deveIdentificarTrianguloIsoscelesCaso1() {
    Triangulo triangulo = new Triangulo(5, 5, 3);
    assertTrue(triangulo.isTriangulo());
    assertEquals(TipoTriangulo.ISOSCELES, triangulo.getTipo());
}

@Test
public void deveIdentificarTrianguloIsoscelesCaso2() {
    Triangulo triangulo = new Triangulo(5, 3, 5);
    assertTrue(triangulo.isTriangulo());
    assertEquals(TipoTriangulo.ISOSCELES, triangulo.getTipo());
}

@Test
public void deveIdentificarTrianguloIsoscelesCaso3() {
    Triangulo triangulo = new Triangulo(3, 5, 5);
    assertTrue(triangulo.isTriangulo());
    assertEquals(TipoTriangulo.ISOSCELES, triangulo.getTipo());
}

@Test
public void deveIdentificarTrianguloEquilatero() {
    Triangulo triangulo = new Triangulo(4, 4, 4);
    assertTrue(triangulo.isTriangulo());
    assertEquals(TipoTriangulo.EQUILATERO, triangulo.getTipo());
}

@Test
public void deveRetornarFalsoParaValorZero() {
    Triangulo triangulo = new Triangulo(0, 4, 4);
    assertFalse(triangulo.isTriangulo());
    assertNull(triangulo.getTipo());
}

@Test
public void deveRetornarFalsoParaValorNegativo() {
    Triangulo triangulo = new Triangulo(-1, 4, 4);
    assertFalse(triangulo.isTriangulo());
    assertNull(triangulo.getTipo());
}

@Test
public void deveRetornarFalsoParaSomaDoisLadosIgualTerceiroCaso1() {
    Triangulo triangulo = new Triangulo(2, 3, 5);
    assertFalse(triangulo.isTriangulo());
    assertNull(triangulo.getTipo());
}

@Test
public void deveRetornarFalsoParaSomaDoisLadosIgualTerceiroCaso2() {
    Triangulo triangulo = new Triangulo(3, 5, 2);
    assertFalse(triangulo.isTriangulo());
    assertNull(triangulo.getTipo());
}

@Test
public void deveRetornarFalsoParaSomaDoisLadosIgualTerceiroCaso3() {
    Triangulo triangulo = new Triangulo(5, 2, 3);
    assertFalse(triangulo.isTriangulo());
    assertNull(triangulo.getTipo());
}

@Test
public void deveRetornarFalsoParaSomaDoisLadosMenorTerceiroCaso1() {
    Triangulo triangulo = new Triangulo(2, 2, 5);
    assertFalse(triangulo.isTriangulo());
    assertNull(triangulo.getTipo());
}

@Test
public void deveRetornarFalsoParaSomaDoisLadosMenorTerceiroCaso2() {
    Triangulo triangulo = new Triangulo(5, 2, 2);
    assertFalse(triangulo.isTriangulo());
    assertNull(triangulo.getTipo());
}

@Test
public void deveRetornarFalsoParaSomaDoisLadosMenorTerceiroCaso3() {
    Triangulo triangulo = new Triangulo(2, 5, 2);
    assertFalse(triangulo.isTriangulo());
    assertNull(triangulo.getTipo());
}

@Test
public void deveRetornarFalsoParaTodosValoresZero() {
    Triangulo triangulo = new Triangulo(0, 0, 0);
    assertFalse(triangulo.isTriangulo());
    assertNull(triangulo.getTipo());
}
    @Test
    public void deveRetornarFalsoQuandoLado2Zero() {
        Triangulo triangulo = new Triangulo(4, 0, 4);
        assertFalse(triangulo.isTriangulo());
        assertNull(triangulo.getTipo());
    }

    @Test
    public void deveRetornarFalsoQuandoLado3Zero() {
        Triangulo triangulo = new Triangulo(4, 4, 0);
        assertFalse(triangulo.isTriangulo());
        assertNull(triangulo.getTipo());
    }

}