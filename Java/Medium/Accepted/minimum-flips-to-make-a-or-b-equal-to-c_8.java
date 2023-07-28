class Solution {
    public int minFlips(int a, int b, int c) {
        
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if (((a >> i) & 1) == 1 && ((b >> i) & 1) == 1 && ((c >> i) & 1) == 0) {
                count += 2;
            } else if (((a >> i) & 1) == 1 && ((b >> i) & 1) == 0 && ((c >> i) & 1) == 0) {
                count += 1;
            } else if (((a >> i) & 1) == 0 && ((b >> i) & 1) == 1 && ((c >> i) & 1) == 0) {
                count += 1;
            } else if (((a >> i) & 1) == 0 && ((b >> i) & 1) == 0 && ((c >> i) & 1) == 1) {
                count += 1;
            }
        }
        return count;
    }
}