class Solution {
    public int superPow(int a, int[] b) {
        
        int result = 1;
        for (int i = 0; i < b.length; i++) {
            result = pow(result, 10) * pow(a, b[i]) % 1337;
        }
        return result;
    }
}