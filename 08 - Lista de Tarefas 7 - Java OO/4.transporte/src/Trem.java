public class Trem implements IMeioTransporte {

    private int velocidade;
    private final int VELOCIDADE_MAXIMA = 200;

    public Trem() {
        this.velocidade = 0;
    }

    @Override
    public void acelerar() {
        if (velocidade >= VELOCIDADE_MAXIMA) {
            throw new IllegalStateException("O trem já está na velocidade máxima.");
        }
        this.velocidade += 20;
        System.out.println("Trem acelerando. Velocidade atual: " + this.velocidade + " km/h");
    }

    @Override
    public void frear() {
        if (velocidade <= 0) {
            throw new IllegalStateException("O trem ja esta parado.");
        }
        this.velocidade -= 20;
        System.out.println("Trem freando. Velocidade atual: " + this.velocidade + " km/h");
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

