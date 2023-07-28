class Solution {
    public int threeSumMulti(int[] arr, int target) {
        
        int mod = 1000000007;
        long[] c = new long[101];
        for (int x: arr) c[x]++;
        long res = 0;
        for (int i = 0; i <= 100; i++)
            for (int j = i; j <= 100; j++) {
                int k = target - i - j;
                if (k < 0 || k > 100) continue;
                if (i == j && j == k) res += c[i] * (c[i] - 1) * (c[i] - 2) / 6;
                else if (i == j && j != k) res += c[i] * (c[i] - 1) / 2 * c[k];
                else if (i < j && j < k) res += c[i] * c[j] * c[k];
            }
        return (int) (res % mod);
    }
}