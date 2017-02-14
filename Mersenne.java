/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mersenne;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author aaacevedo
 */
public class Mersenne {
public static final BigInteger TWO = new BigInteger("2");
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la potencia p");
        int p = sc.nextInt(); 
        BigInteger n = TWO.pow(p).subtract(BigInteger.ONE);
        System.out.println("El numero de Mersenne con indice "+ p+" es:");
        System.out.println(n);
        // TODO code application logic here
    }
    
}
