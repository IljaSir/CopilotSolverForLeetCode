class Solution {
    public int smallestRepunitDivByK(int k) {
        
        if (k % 2 == 0 || k % 5 == 0) {
            return -1;
        }
        int remainder = 0;
        for (int lengthN = 1; lengthN <= k; lengthN++) {
            remainder = (remainder * 10 + 1) % k;
            if (remainder == 0) {
                return lengthN;
            }
        }
        return -1;
    }
}