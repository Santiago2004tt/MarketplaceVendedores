package MarketplaceVendedores.model;

import java.io.Serializable;

/**
 * clase meGusta
 * ---English---
 * iLike class
 */
public class MeGusta implements Serializable {
    private static final long serialVersioUID = 1L;

    private Vendedor vendedor;

    public MeGusta(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public MeGusta(){

    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
}
