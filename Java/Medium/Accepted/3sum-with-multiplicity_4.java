class Solution {
    public int threeSumMulti(int[] arr, int target) {
        
        int[] count = new int[101];
        for (int num : arr) {
            count[num]++;
        }
        long res = 0;
        for (int i = 0; i <= 100; i++) {
            for (int j = i; j <= 100; j++) {
                int k = target - i - j;
                if (k < 0 || k > 100) {
                    continue;
                }
                if (i == j && j == k) {
                    res += (long)count[i] * (count[i] - 1) * (count[i] - 2) / 6;
                } else if (i == j && j != k) {
                    res += (long)count[i] * (count[i] - 1) / 2 * count[k];
                } else if (j < k) {
                    res += (long)count[i] * count[j] * count[k];
                }
            }
        }
        return (int)(res % 1000000007);
    }
}