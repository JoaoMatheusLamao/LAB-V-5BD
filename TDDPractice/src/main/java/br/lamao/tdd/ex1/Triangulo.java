package br.lamao.tdd.ex1;

public class Triangulo {
    private int l1, l2, l3;

    public Triangulo(int l1, int l2, int l3) {
        this.l1 = l1;
        this.l2 = l2;
        this.l3 = l3;
    }

    public boolean isTriangulo() {
        return l1 > 0 && l2 > 0 && l3 > 0 &&
                l1 + l2 > l3 &&
                l1 + l3 > l2 &&
                l2 + l3 > l1;
    }

    public TipoTriangulo getTipo() {
        if (!isTriangulo()) {
            return null;
        }

        if (l1 == l2 && l2 == l3) {
            return TipoTriangulo.EQUILATERO;
        } else if (l1 == l2 || l1 == l3 || l2 == l3) {
            return TipoTriangulo.ISOSCELES;
        } else {
            return TipoTriangulo.ESCALENO;
        }
    }
}
