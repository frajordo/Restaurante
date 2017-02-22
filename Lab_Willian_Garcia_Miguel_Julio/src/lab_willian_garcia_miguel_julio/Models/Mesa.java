package lab_willian_garcia_miguel_julio.Models;

import java.util.ArrayList;

public class Mesa {
int id;
ArrayList <Pedido> pedidos= new ArrayList <>();
    public Mesa(int id) {
        this.id = id;
    }
}
