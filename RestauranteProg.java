

import javax.swing.JOptionPane;

public class RestauranteProg{
    /* 
    Significado de las variables:
    platillosS = platillos semanales
    platilloO = platillo en oferta
    codigoPS = codigo de platillo semanal
    codigoPO = codigo de platillo diario en oferta
    precioPS = precio platillo semanal
    precioPO = precio platillo oferta
    res = respuesta
    acum = acumulador */

    private String empleadoCaja[] = new String [50];
    private String platillos[][] = new String [1][6];
    private String codigoPS;
    private int pedidoCant[] = new int[200];
    private String platilloO[] = new String[6];
    private double precioPS[] = new double [6];
    private double precioPO[] = new double[6];
    private String pedidos[] =  new String[500];
    private String res, vR;
    private int acum=0, acum2 = 0, opcionPO;

    String platillo[][] = {{"Pimientos rellenos de quinoa", 
    "Huevos revueltos" , 
    "Salmón a la plancha", 
    "Pollo a la plancha",
    "Gambones a la plancha",
    "Huevos a la plancha",
    "Tortilla francesa"},{"2.50", "2.00", "6.00","6.60", "8.00", "3.00", "2.70"}};

    public void CargarEmpleado(String vR){
        res = vR;
        for (int i = 0; i < 1; i++) {
            empleadoCaja[acum] = res; 
            acum = acum + 1;
        }
    }

    public String MostrarPlatillosSemanal(){

        String platillosM = "";
        int num = 1;
        // Se muestran los platillos precargados
        for(int i = 0; i<= 6; i++){
            platillosM = platillosM + "\n"+num+"."+  platillo[0][i]+ " | " + platillo[1][i] + "\n";
            num = num + 1;
        }
        return platillosM;
    }

    

    public void CargarPO(){
        String platillosM = "";
        int num = 1;
        int iNum = 0;
        
        for(int i = 0; i<= platillos.length; i++){
            platillosM = platillosM + "\n"+num+"."+  platillo[i]+ "\n";
            num = num + 1;
        }

        iNum = Integer.parseInt(JOptionPane.showInputDialog(null, platillosM, "Elija el platillo del día en oferta", JOptionPane.QUESTION_MESSAGE));
        opcionPO = Integer.parseInt(JOptionPane.showInputDialog(null, platillo[iNum], "Coloque el descuento del platillo", JOptionPane.INFORMATION_MESSAGE));
        //OpcionPO Guarda la info del descuento del platillo del día
    }


    public void PedidoCliente(){
        acum2 = 0;
        RestauranteProg rp = new RestauranteProg();
        do {
            opcionPO = Integer.parseInt(JOptionPane.showInputDialog(null, rp.MostrarPlatillosSemanal() + "\n" + "\n0.Finalizar pedido"));
            // coloco un condicional para saber si lo que llega es un numero distinto de 0
            if(opcionPO != 0){
                codigoPS = JOptionPane.showInputDialog(null, "Ingrese el codigo del platillo");
                pedidos[acum2] = codigoPS;
                pedidoCant[acum2] = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad"));
                /* System.out.println(pedidoCant[acum2]); // debug para saber si la cantidad se está guardando */

                /* System.out.println(pedidos[acum2]);  // debug para saber si los pedidos se cargan*/
                acum2 = acum2 + 1;
            }
        } while (opcionPO != 0);
    }

    public void menu(){
        RestauranteProg rp = new RestauranteProg();
        // se hace un bucle infinito
        do {
                // Menu con las opciones
                res= JOptionPane.showInputDialog(null,
                        "a.Elegir el descuento del platillo del día\n"+
                        "b.Pedido del cliente\n"+
                        "c.Terminar turno del empleado\n"+
                        "d.Terminar turno del día\n"+
                        "e.Salir del programa");
                // Se evalua lo que manda "res" por medio del switch
                        switch (res) {
                            case "a":
                                rp.CargarPO();
                            break;
                            case "b":
                                rp.PedidoCliente();
                            break;
                            case "c":
                                int res2 = JOptionPane.showConfirmDialog(null,"¿Termino su turno?");
                                switch (res2) {
                                    case JOptionPane.YES_OPTION:
                                        vR = JOptionPane.showInputDialog( null, "Empleado ingrese su nombre: ");
                                        rp.CargarEmpleado(vR);
                                    break;

                                    // en caso que elija no, no devuelve nada y este retorna al menu
                                }
                            break;
                            case "d":
                                // Aqui va el siguiente metodo
                            break;
                            case "e":
                                // Se pregunta al usuario si quiere salir del programa
                                 int res3 = JOptionPane.showConfirmDialog(null, "¿Realmente quiere salir?");
                                switch (res3) {
                                    case JOptionPane.YES_OPTION:
                                        res = "0";    
                                    break;
                                    case JOptionPane.NO_OPTION:
                                        res="";
                                    break;
                                    case JOptionPane.CANCEL_OPTION:
                                        res = "0";
                                    break;
                                    
                                }
                            break;
                        
                            default:
                                JOptionPane.showMessageDialog(null,"INGRESE UNA OPCION VALIDA \n","ERROR OPCION",JOptionPane.WARNING_MESSAGE);
                            break;
                        }
        } while (res != "0");
        


    }

    public static void main(String[] args) {
        String vR;
        RestauranteProg rp = new RestauranteProg();
        // De primera se pide el nombre del empleado
        vR = JOptionPane.showInputDialog( null, "Empleado ingrese su nombre: ");
        rp.CargarEmpleado(vR);
        rp.menu();
    }





}