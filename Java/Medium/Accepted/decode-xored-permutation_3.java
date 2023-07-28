class Solution {
    public int[] decode(int[] encoded) {
        
        int n = encoded.length + 1;
        int[] perm = new int[n];
        int all = 0;
        for (int i = 1; i <= n; i++) {
            all ^= i;
        }
        int odd = 0;
        for (int i = 1; i < n - 1; i += 2) {
            odd ^= encoded[i];
        }
        perm[0] = all ^ odd;
        for (int i = 1; i < n; i++) {
            perm[i] = perm[i - 1] ^ encoded[i - 1];
        }
        return perm;
    }
}