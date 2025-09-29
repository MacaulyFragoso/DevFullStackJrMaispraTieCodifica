public class Carro implements IMeioTransporte {

    private int velocidade;
    private final int VELOCIDADE_MAXIMA = 120;

    public Carro() {
        this.velocidade = 0;
    }

    @Override
    public void acelerar() {
        if (velocidade >= VELOCIDADE_MAXIMA) {
            throw new IllegalStateException("O carro já está na velocidade máxima.");
        }
        this.velocidade += 10;
        System.out.println("Carro acelerando. Velocidade atual: " + this.velocidade + " km/h");
    }

    @Override
    public void frear() {
        if (velocidade <= 0) {
            throw new IllegalStateException("O carro já está parado.");
        }
        this.velocidade -= 10;
        System.out.println("Carro freando. Velocidade atual: " + this.velocidade + " km/h");
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
