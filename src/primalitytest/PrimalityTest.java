/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primalitytest;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Alberto pc
 */
public class PrimalityTest {
    
    private static final BigInteger ZERO = BigInteger.ZERO;
    private static final BigInteger ONE = BigInteger.ONE;
    private static final BigInteger TWO = new BigInteger("2");
    private static final BigInteger THREE = new BigInteger("3");
    private static final BigInteger FIVE = new BigInteger("5");
    private static final BigInteger SEVEN = new BigInteger("7");
    

    public static BigInteger squareRoot(BigInteger n){
        if (n.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException("Negative argument.");
        }
        if (n.equals(BigInteger.ZERO) || n.equals(BigInteger.ONE)) {
            return n;
        }
        BigInteger y = n.divide(TWO);
        while (y.compareTo(n.divide(y))> 0) {            
            y = ((n.divide(y)).add(y)).divide(TWO);
        }
        return y;
    }
    
    private static BigInteger uniformRandom(BigInteger bottom, BigInteger top) {
		Random rnd = new Random();
		BigInteger res;
		do {
			res = new BigInteger(top.bitLength(), rnd);
		} while (res.compareTo(bottom) < 0 || res.compareTo(top) > 0);
		return res;
	}
	private static BigInteger actualRandom(BigInteger bottom, BigInteger top){
		Random rnd = new Random();
		BigInteger res;
		res = new BigInteger(top.bitLength(), rnd).mod((top.subtract(botom).add(BigInteger.ONE)).add(bottom));
		return res;
	}
    
    private static boolean isPrime(BigInteger p, int k){
        if (p.compareTo(BigInteger.ONE) <= 0) {
            return false;
        }
        if (p.equals(TWO)) {
                return true;
            }
        if (p.mod(TWO).equals(ZERO)) {   
            return false;
        }
        if (p.compareTo(new BigInteger("7")) <=0) {
            return true;
        }
        if (p.mod(THREE).equals(ZERO) || p.mod(FIVE).equals(ZERO) || p.mod(SEVEN).equals(ZERO)) {
            return false;
        }
        BigInteger sqrt = squareRoot(p);
        if (p.equals(sqrt.multiply(sqrt))) {
            return false;
        }
        BigInteger a;
        for (int i = 0; i < k; i++) {
            a = actualRandom(TWO, p.subtract(ONE));
            if (!a.modPow(p.subtract(ONE), p).equals(ONE)) {
                return false;
            }
        }
        return true;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        boolean active = true;
//        while(active){
//        BigInteger n = sc.nextBigInteger();
//            if (n.equals(new BigInteger("-1"))) {
//                active = false;
//            }
//            else{
//                boolean isPrime = isPrime(n, 10);
//                System.out.println(isPrime);
//            }
//        }
        BigInteger n = sc.nextBigInteger();
        System.out.println(isPrime(n,10));
        // TODO code application logic here
    }
    
}
