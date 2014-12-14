package projecteuler.problems;

import java.util.Arrays;

/**
 *
 * @author lazar
 */
public class Problem27 {
    public static void main(String[] args) {
        boolean[] primes = calcPrimesLessThen20000();
        primes[0] = false;
        primes[1] = false;
        
        int mostPrimes = 0, bestA = 0, bestB = 0;
        
        for(int a = -999; a < 1000; a++) {
            for(int b = -999; b < 1000; b++) {
                int cnt = calcPrimesForCoefs(primes, a, b);
                if(cnt > mostPrimes) {
                    mostPrimes = cnt;
                    bestA = a;
                    bestB = b;
                    System.out.println(bestA + " <-> " + bestB + " // " + mostPrimes);
                }
                
            }
        }
        
        System.out.println(bestA + " -- " + bestB + "====" + bestA*bestB);
    }
    
    private static int calcPrimesForCoefs(boolean[] primes, int a, int b) {
        int cnt = 0;
        int n = 0;
        int idx = n*n + a*n + b;
        if(idx < 0) {
            idx = -idx;
        }
        
        while(primes[idx]) {
            n++;
            idx = n*n + a*n + b;
            if(idx < 0) {
                idx = -idx;
            }
            cnt ++;
        }
        
        return cnt;
    }
    
    private static boolean[] calcPrimesLessThen20000() {
        boolean[] primes = new boolean[20000];
        Arrays.fill(primes, true);
        
        for(int i = 2; i < 10002; i ++) {
            if(!primes[i]) {
                continue;
            }
            
            int iter = i+i;
            while(iter < 20000) {
                primes[iter] = false;
                iter+=i;
            }
        }
        
        return primes;
    }
}
