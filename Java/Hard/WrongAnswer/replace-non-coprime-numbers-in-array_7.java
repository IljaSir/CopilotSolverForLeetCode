class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        
        List<Integer> result = new ArrayList<>();
        int[] primeFactors = new int[100001];
        for (int i = 2; i < 100001; i++) {
            if (primeFactors[i] == 0) {
                for (int j = i; j < 100001; j += i) {
                    if (primeFactors[j] == 0) {
                        primeFactors[j] = i;
                    }
                }
            }
        }
        int[] maxPrimeFactors = new int[100001];
        for (int i = 2; i < 100001; i++) {
            int num = i;
            while (num > 1) {
                int primeFactor = primeFactors[num];
                maxPrimeFactors[i] = Math.max(maxPrimeFactors[i], primeFactor);
                while (num % primeFactor == 0) {
                    num /= primeFactor;
                }
            }
        }
        for (int num : nums) {
            if (maxPrimeFactors[num] != 0) {
                result.add(maxPrimeFactors[num]);
            } else {
                result.add(num);
            }
        }
        return result;
    }
}