package sbu.cs.CalculatePi;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
public class PiCalculator {
    /**
     * Calculate pi and represent it as a BigDecimal object with the given floating point number (digits after .)
     * There are several algorithms designed for calculating pi, it's up to you to decide which one to implement.
     * Experiment with different algorithms to find accurate results.
     * You must design a multithreaded program to calculate pi. Creating a thread pool is recommended.
     * Create as many classes and threads as you need.
     * Your code must pass all of the test cases provided in the test folder.
     *
     * @param floatingPoint the exact number of digits after the floating point
     * @return pi in string format (the string representation of the BigDecimal object)
     */
    public String calculate(int floatingPoint) {
        BigDecimal pi = BigDecimal.ZERO;
        int numThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);
        try {
            Future<BigDecimal>[] results = new Future[numThreads];
            int workloadPerThread = floatingPoint / numThreads;
            int remainingWorkload = floatingPoint % numThreads;
            int startIndex = 0;
            for (int i = 0; i < numThreads; i++) {
                int endIndex = startIndex + workloadPerThread - 1;
                if (i < remainingWorkload) {
                    endIndex++;
                }
                results[i] = executorService.submit(new PiCalculatorTask(startIndex, endIndex));
                startIndex = endIndex + 1;
            }
            for (int i = 0; i < numThreads; i++) {
                BigDecimal partialPi = results[i].get();
                pi = pi.add(partialPi);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
        pi = pi.setScale(floatingPoint, RoundingMode.HALF_UP);

        return pi.toString();
    }
    private static class PiCalculatorTask implements Callable<BigDecimal> {
        private final int startIndex;
        private final int endIndex;
        public PiCalculatorTask(int startIndex, int endIndex) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }
        @Override
        public BigDecimal call() {
            BigDecimal result = BigDecimal.ZERO;
            BigDecimal sixteenPow = BigDecimal.valueOf(16).pow(endIndex);
            for (int i = startIndex; i <= endIndex; i++) {
                BigDecimal denominator1 = BigDecimal.valueOf(8 * i + 1);
                BigDecimal denominator2 = BigDecimal.valueOf(8 * i + 4);
                BigDecimal denominator3 = BigDecimal.valueOf(8 * i + 5);
                BigDecimal denominator4 = BigDecimal.valueOf(8 * i + 6);
                BigDecimal term = BigDecimal.ONE
                        .divide(denominator1, 20, RoundingMode.HALF_UP)
                        .subtract(BigDecimal.ONE.divide(denominator2, 20, RoundingMode.HALF_UP)
                                .subtract(BigDecimal.ONE.divide(denominator3, 20, RoundingMode.HALF_UP))
                                .add(BigDecimal.ONE.divide(denominator4, 20, RoundingMode.HALF_UP))
                                .divide(BigDecimal.valueOf(16).pow(i), 20, RoundingMode.HALF_UP));
                result = result.add(term);
            }
            return result;
        }
    }
    public static void main(String[] args) {
        PiCalculator calculator = new PiCalculator();
        String pi = calculator.calculate(1000);
        System.out.println(pi);
    }
}
