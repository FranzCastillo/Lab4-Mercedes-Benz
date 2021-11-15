import Carros.*;
import Carros.Tipos.*;

public class MercedesBenz {
    private Carro carroActual;
    private Vista v;
    
    public MercedesBenz(){
        v = new Vista();
        carroActual = null;
    }

    public void ejecutar(){
        while(true){
            // --------------------- MENU SELECCION DE TIPO DE CARRO ---------------
            boolean regresarSeleccionCarro = false;
            int tipoCarro = v.seleccionarCarro();
            crearCarro(tipoCarro);
            while(!carroActual.getEncendido() && !regresarSeleccionCarro){
                //------------------ MENU DE SELECCION DE MODO --------------------
                if(v.deseaEncenderCarro()){ // EL CARRO SE ENCIENDE
                    carroActual.setEncendido(true);
                    while(carroActual.getEncendido()){
                        int opcion = v.seleccionarModo();
                        switch(opcion){
                            case 1: // MODO PRODUCTIVIDAD
                                modoProductividad();
                            break;
                            case 2: // MODO RADIO
                                modoRadio();
                            break;
                            case 3: // MODO REPRODUCCION
                                modoReproduccion();
                            break;
                            case 4: // MODO TELEFONO
                                modoTelefono();
                            break;
                            case 5: // APAGAR CARRO
                                carroActual.setEncendido(false);
                            break;
                        }
                    }
                }else{ // SI INGRESA QUE DESEA REGRESAR A LA SELECCION DE AUTOS TERMINA EL WHILE DE ESTE MENU
                    regresarSeleccionCarro = true; 
                }
            }
        }
    }
    private void crearCarro(int tipoCarro){
        switch(tipoCarro){
            case 1: //CARRO TIPO C
                carroActual = new CarroC();
            break;
            case 2: // TIPO A
                carroActual = new CarroA();
            break;
            case 3: // TIPO S
                carroActual = new CarroS();
            break;
            case 4: //SALIR
                System.exit(1); 
            break;
            
        }    
    }
    private void modoProductividad(){
        boolean salirModoProductividad = false;
        while(!salirModoProductividad){
            int opcion = v.mostrarMenuProductividad(carroActual);
            switch(opcion){
                case 1: // FUNCIONALIDAD
                    v.mostrarModoProductividad(carroActual.modoProductividad());
                break;
                case 2: // SALIR
                    salirModoProductividad = true;
                break;
                default:
                    v.opcionInvalida();
                break;
            }
        }
    }
    private void modoRadio(){
        boolean salirModoRadio = false;
        while(!salirModoRadio){
            if(!carroActual.radioEncendido()){ // SI EL RADIO NO ESTA ENCENDIDO
                if(v.deseaEncenderRadio()){
                    carroActual.setRadioEncendido(true);
                }else{
                    salirModoRadio = true;
                }
            }
            while(carroActual.radioEncendido() && !salirModoRadio){ // SI EL RADIO NO ESTA ENCENDIDO, NO ENTRA EN ESTE CICLO
                int opcion = v.mostrarMenuRadio();
                switch(opcion){
                    case 1: // FM ←→ AM
                    break;
                    case 2: // CAMBIAR EMISORA
                    break;
                    case 3: // GUARDAR EMISORA
                    break;
                    case 4: // CARGAR EMISORA 
                    break;
                    case 5: // APAGAR RADIO
                        carroActual.setRadioEncendido(false);
                    break;
                    case 6: // SALIR MODO RADIO
                        salirModoRadio = true;
                    break;
                    default:
                        v.opcionInvalida();
                    break;
                }
            }
        }
    }
    private void modoReproduccion(){
        boolean salirModoReproduccion = false;
        while(!salirModoReproduccion){
            int opcion = v.mostrarMenuReproduccion();
            switch(opcion){
                case 1: // SELECCIONAR LISTA DE REPRODUCCION
                break;
                case 2: // CAMBIAR CANCION
                break;
                case 3: // ESCUCHAR CANCION
                break;
                case 4: // SALIR MODO REPRODUCCION
                    salirModoReproduccion = true;
                break;
            }
        }
    }
    private void modoTelefono(){
        boolean salirModoTelefono = false;
        while(!salirModoTelefono){
            if(!carroActual.telefonoConectado()){ // SI EL TELEFONO NO ESTA CONECTADO
                if(v.deseaConectarTelefono()){
                    carroActual.setTelefonoConectado(true);
                }else{
                    salirModoTelefono = true;
                }
            }
            while(carroActual.telefonoConectado() && !salirModoTelefono){ // SI EL TELEFONO NO ESTA CONECTADO, NO ENTRA EN ESTE CICLO
                int opcion = v.mostrarMenuTelefono(carroActual);
                switch(opcion){
                    case 1: // DESCONECTAR TELEFONO
                        carroActual.setTelefonoConectado(false);
                    break;
                    case 2: // MOSTRAR CONTACTOS
                    break;
                    case 3: // LLAMAR CONTACTO
                    break;
                    case 4: // FINALIZAR LLAMADA
                    break;
                    case 5: // FUNCIONALIDAD ESPECIFICA DE CADA CARRO
                        carroActual.modoTelefonoEspecifico();
                    break;
                    case 6: // SALIR MODO TELEFONO
                        salirModoTelefono = true;
                    break;
                    default:
                        v.opcionInvalida();
                    break;
                }
            }
        }
    }
}