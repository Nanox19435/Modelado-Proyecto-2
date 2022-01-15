package proyecto.modelo.entidades;

import java.util.Random;
/**
 * Generador de nombres.
 * Guardamos en esta clase un banco de nombres al igual que apellidos, esto
 * con el fin de tener a cada prisionero y guardia con un nombre distinto. 
 * Claro existe la posibilidad de duplicacion pero al igual que en la realidad,
 * esta situacion pasa.
 */
public class Nombres{

    /* El banco de nombres */
    static private String[] nombre = new String[]{"Antonio", "Juan", "Fernando", "Tania", "Daniel", "Marco", "Gerardo", "Mariana", "Esmeralda", "Mónica", "Jimena", "Carmen", "Jesús", "Cristian", "Maria", "Uriel", "Alejandro", "Arturo", "Rosa", "Rodrigo", "Ramón", "Rafael", "Itzel", "Sandra", "Daniela"};

    /* El banco de apellidos */
    static private String[] apellido = new String[]{"Hernandez", "Garcia", "Alvarado", "Zenteno", "Arce", "Cortés", "Trejo", "González", "Rodríguez", "Sánchez", "López", "Pérez", "Martínez", "Ramírez", "Cruz", "Gómez", "Flores"};

    /**
     * Regresa un nombre generado aleatoriamente de los bancos.
     * @return en cadena un nombre y dos apellidos.
     */
    public static String getNombre(){
	Random rand = new Random();

	return nombre[rand.nextInt(nombre.length)] + " " + apellido[rand.nextInt(apellido.length)] + " " + apellido[rand.nextInt(apellido.length)];	
    }
}
