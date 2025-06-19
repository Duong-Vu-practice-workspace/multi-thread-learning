package org.example.thread_coordination.exercises;

import java.math.BigInteger;

public class ComplexCalculation{
    public BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2) {
        PowerThread thread1 = new PowerThread(base1, power1);
        PowerThread thread2 = new PowerThread(base2, power2);
        thread1.start();
        thread2.start();
        try {
            thread1.join(2000);
            thread2.join(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        BigInteger result1 = thread1.getResult();
        BigInteger result2 = thread2.getResult();

        BigInteger result = result1.add(result2);
        System.out.println("Result: " + result);
        return result;
    }
    public static class PowerThread extends Thread {
        private BigInteger base;
        private BigInteger power;
        private BigInteger result = BigInteger.ONE;
        public PowerThread(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }
        @Override
        public void run() {
            this.result = this.calculatePower();
        }
        public BigInteger calculatePower(){
            for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
                result = result.multiply(base);
            }
            return result;
        }

        public BigInteger getResult() {
            return result;
        }
    }
}
