import java.util.Scanner;

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
    private String platillosS[] = new String [2];// para probarlo bajé la cantidad de platillos en el día. Volver a colocar los valores que son
    private String codigoPS[]= new String[2];// para probarlo bajé la cantidad de platillos en el día. Volver a colocar los valores que son
    private String codigoPO[]= new String[2];// para probarlo bajé la cantidad de platillos en el día. Volver a colocar los valores que son
    private String platilloO[] = new String[2];// para probarlo bajé la cantidad de platillos en el día. Volver a colocar los valores que son
    private double precioPS[] = new double [2];// para probarlo bajé la cantidad de platillos en el día. Volver a colocar los valores que son
    private double precioPO[] = new double[2];// para probarlo bajé la cantidad de platillos en el día. Volver a colocar los valores que son
    private String res, vR;
    private int acum=0, acum2 = 0;
    Scanner dta = new Scanner(System.in);

    public void CargarEmpleado(String vR){
        res = vR;
        for (int i = 0; i < 1; i++) {
            empleadoCaja[acum] = dta.nextLine();
            acum= acum + 1;
        }
    }

    public void CargarPlatillosSemanal(){
        System.out.println("Ingrese los platillos Semanales: ");
        /* De primera se ejecuta esta parte ya que se tienen que introducir los platillos semanales primero */
        for(int i = 0; i< platillosS.length; i++){
            System.out.println("Ingrese el Nombre del platillo " + (i + 1));
            platillosS[i]= dta.nextLine();
            System.out.println("Ingrese el precio del platillo");
            precioPS[i]= dta.nextDouble();
            System.out.println("Ingrese el codigo del platillo");
            codigoPS[i]= dta.nextLine();
        }
        System.out.println("Platillos cargados");
    }
    public void CargarPlatilloOferta(){
        System.out.println("Ingrese el platillo diario: ");
        for (int i = 0; i < 1; i++) {
            /* Utilizo un for para evaluar la condicion una sola ves y el indice del arreglo es acum2 
            el cual empieza en 0 la primera ves y luego va aumentando creando una forma de introducir 
            datos sin tener que espesificar el indice */
            platilloO[acum2] = dta.nextLine();
            System.out.println("Ingrese el codigo del platillo");
            codigoPO[acum2] = dta.nextLine();
            System.out.println("Ingrese el precio del platillo");
            precioPO[acum2] = dta.nextDouble();
            acum2 = acum2 + 1;
        }
    }

    public void menu(){
        RestauranteProg rp = new RestauranteProg();
        /* Se resetea la condicion en nada por si acaso la variable viene llena */
        res="";
        do {
            /* Se hace un bucle infinito para el menu en caso de que res sea = "0" el bucle finaliza */
            System.out.println("Elija un opcion: ");
            System.out.println("a.Cargar platillo diario en Oferta\nb.Terminar Turno\nc.Salir del programa");
            res = dta.nextLine();
            switch(res){
                case"a":
                rp.CargarPlatilloOferta();       
                break;
                case"b":
                    System.out.println("¿Desea terminar su turno?\n[S(Si)/N(no)]");
                    res = dta.nextLine();
                    if(res.equals("S")){
                        System.out.println("¿Terminó el dia?\n[S(Si)/N(no)]");
                        res = dta.nextLine();
                        if(res.equals("S")){
                            do {
                                System.out.println("Elija un opcion: ");
                                System.out.println("a.Ventas Diarias por platillo\nb.La distribución porcentual diaria de las ventas totales por platillo\nc.Platillo más vendido en el día\nd.Platillo menos vendido en el día\ne.Monto otorgado en descuento de jubilado por día\nf.Avanzar a otro Día");
                                //Dejo preparado el switch case para que introduzcan los metodos correspondientes, solo descomentar y asignar el metodo
                                    res = dta.nextLine();
                                switch (res) {
                                    case "a":
                                        
                                    break;
                                    case "b":
                                        
                                    break;
                                    
                                    case "c":
                                        
                                    break;
                                    case "d":
                                        
                                    break;
                                    case "f":
                                        System.out.println("Ingrese el nombre del empleado: ");
                                        vR = dta.nextLine();
                                        rp.CargarEmpleado(vR);
                                        res = "0";
                                    break;
                                }

                            } while (res != "0");
                        }
                    }

                break;
                case "c":
                    System.out.println("¿Desea salir del programa?\n[S(Si)/N(no)]");
                    res = dta.nextLine();
                    if(res.equals("S")){
                        res = "0";
                    }
                break;
    
            }
        } while (res != "0");


    }

    public static void main(String[] args) {
        String vR;
        Scanner dta = new Scanner(System.in);
        RestauranteProg rp = new RestauranteProg();
        System.out.println("Bienvenido");
        rp.CargarPlatillosSemanal();
        System.out.println("Ingrese el nombre del empleado");
        vR= dta.nextLine();
        rp.CargarEmpleado(vR);
        dta.close();
        rp.menu();
    }





}