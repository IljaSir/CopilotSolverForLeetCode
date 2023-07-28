class Solution {
    public int countTriplets(int[] arr) {
        
        int n = arr.length;
        int[] xors = new int[n + 1];
        for (int i = 0; i < n; i++) {
            xors[i + 1] = xors[i] ^ arr[i];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int k = i + 1; k < n; k++) {
                if (xors[i] == xors[k + 1]) {
                    ans += k - i;
                }
            }
        }
        return ans;
    }
}