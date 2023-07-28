class Solution {
    public int arrayPairSum(int[] nums) {
        
        int sum = 0;
        int[] bucket = new int[20001];
        for (int num : nums) {
            bucket[num + 10000]++;
        }
        boolean odd = true;
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i] > 0) {
                if (odd) {
                    sum += i - 10000;
                }
                odd = !odd;
                bucket[i]--;
            }
        }
        return sum;
    }
}