class Solution {
    public String baseNeg2(int n) {
        
        if (n == 0) return "0";
        int[] x = new int[32];
        int i = 0;
        while (n != 0) {
            x[i] = n & 1;
            n = -(n >> 1);
            i++;
        }
        StringBuilder sb = new StringBuilder();
        for (int j = i-1; j >= 0; j--) {
            sb.append(x[j]);
        }
        return sb.toString();
    }
}