class Solution {
    public long minimumRemoval(int[] beans) {
        
        int n = beans.length;
        long sum = 0;
        for (int bean : beans) {
            sum += bean;
        }
        long min = Long.MAX_VALUE;
        for (int i = 2; i * i <= sum; i++) {
            if (sum % i == 0) {
                min = Math.min(min, minRemoval(beans, i));
                min = Math.min(min, minRemoval(beans, (int) (sum / i)));
            }
        }
        return min;
    }

    private long minRemoval(int[] beans, int k) {
        long[] remainders = new long[k];
        for (int bean : beans) {
            remainders[bean % k]++;
        }
        long sum = 0;
        for (int i = 0; i < k; i++) {
            if (remainders[i] > 0) {
                sum += (remainders[i] - 1) * k + i;
            }
        }
        return sum;
    }
}