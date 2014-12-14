package projecteuler.problems;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author lazar
 */
public class Problem29 {
    
    public static void main(String[] args) {
        Set<Power> combos = new HashSet<>();
        for(int a = 2; a<= 100; a++) {
            for(int b = 2; b<= 100; b++) {
                combos.add(new Power(a, b));
            }
        }
        Power[] combosArr = combos.toArray(new Power[combos.size()]);
        for(int i = 0; i<100; i++) {
            System.out.println(combosArr[i].base + " --// " + combosArr[i].power);
        }
        System.out.println("The result is : " + combos.size());
    }
    
    private static final Power[] simplePowers = new Power[101];
    static {
        int i, pwr, product;
        for(i=2; i < 11; i++) {
            for(pwr = 1; pwr < 8; pwr++) {
                product = (int) Math.pow(i, pwr);
                if(product <= 100) {
                    simplePowers[product] = new Power(i, pwr);
                }
            }
        }
    }
    
    private static class Power {
        
        int base, power;
        
        public Power(int base, int power) {
            Power pwr = simplePowers[base];
            if(pwr != null) {
                base = pwr.base;
                power = power * pwr.power;
            }
            this.base = base;
            this.power = power;
        }
        
        @Override
        public boolean equals(Object obj) {
            Power eq = (Power) obj;
            return this.base == eq.base && this.power == eq.power;
        }
    }
}
