public class Bicicleta implements IMeioTransporte {

    private int velocidade;
    private final int VELOCIDADE_MAXIMA = 20;

    public Bicicleta() {
        this.velocidade = 0;
    }

    @Override
    public void acelerar() {
        if (velocidade >= VELOCIDADE_MAXIMA) {
            throw new IllegalStateException("A bicicleta já está na velocidade máxima.");
        }
        this.velocidade += 2;
        System.out.println("Bicicleta acelerando. Velocidade atual: " + this.velocidade + " km/h");
    }

    @Override
    public void frear() {
        if (velocidade <= 0) {
            throw new IllegalStateException("A bicicleta já está parada.");
        }
        this.velocidade -= 2;
        System.out.println("Bicicleta freando. Velocidade atual: " + this.velocidade + " km/h");
    }

    @Override
    public int getVelocidade() {
        return velocidade;
    }

    @Override
    public int getVelocidadeMaxima() {
        return VELOCIDADE_MAXIMA;
    }
}

