package abstractfactory;

public class Boss implements IVaateFactory {
    @Override
    public IFarmarit pueFarmarit() {
        return new BossFarmarit();
    }

    @Override
    public IKengat pueKengat() {
        return new BossKengat();
    }

    @Override
    public ILippis pueLippis() {
        return new BossLippis();
    }

    @Override
    public ITPaita pueTPaita() {
        return new BossTPaita();
    }
}
