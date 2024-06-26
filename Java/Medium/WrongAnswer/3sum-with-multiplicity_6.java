class Solution {
    public int threeSumMulti(int[] arr, int target) {
        
        int mod = 1000000007;
        int[] count = new int[101];
        for (int a: arr) {
            count[a]++;
        }
        long ans = 0;
        for (int i = 0; i <= 100; i++) {
            for (int j = i; j <= 100; j++) {
                int k = target - i - j;
                if (k < j || k > 100) {
                    continue;
                }
                if (i == j && j == k) {
                    ans += (long)count[i] * (count[i] - 1) * (count[i] - 2) / 6;
                } else if (i == j && j != k) {
                    ans += (long)count[i] * (count[i] - 1) / 2 * count[k];
                } else if (j < k) {
                    ans += (long)count[i] * count[j] * count[k];
                }
            }
        }
        return (int)(ans % mod);
    }
}