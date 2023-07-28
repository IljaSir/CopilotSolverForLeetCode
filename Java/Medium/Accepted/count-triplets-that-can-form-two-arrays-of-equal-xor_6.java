class Solution {
    public int countTriplets(int[] arr) {
        
        int n = arr.length;
        int[] xor = new int[n + 1];
        xor[0] = 0;
        for (int i = 0; i < n; i++) {
            xor[i + 1] = xor[i] ^ arr[i];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int k = i + 1; k < n; k++) {
                if (xor[i] == xor[k + 1]) {
                    ans += k - i;
                }
            }
        }
        return ans;
    }
}