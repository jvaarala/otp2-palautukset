package abstractfactory;

public class Adidas implements IVaateFactory {

    public Adidas() {
    }

    @Override
    public IFarmarit pueFarmarit() {
        return new AdidasFarmarit();
    }

    @Override
    public IKengat pueKengat() {
        return new AdidasIKengat();
    }

    @Override
    public ILippis pueLippis() {
        return new AdidasLippis();
    }

    @Override
    public ITPaita pueTPaita() {
        return new AdidasTPaita();
    }
}
