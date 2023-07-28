class Solution {
    public int[] decode(int[] encoded) {
        
        int[] perm = new int[encoded.length + 1];
        int sum = 0;
        for (int i = 1; i <= perm.length; i++) {
            sum ^= i;
        }
        for (int i = 1; i < encoded.length; i += 2) {
            sum ^= encoded[i];
        }
        perm[0] = sum;
        for (int i = 1; i < perm.length; i++) {
            perm[i] = perm[i - 1] ^ encoded[i - 1];
        }
        return perm;
    }
}