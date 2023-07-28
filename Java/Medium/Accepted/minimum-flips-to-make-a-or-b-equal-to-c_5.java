class Solution {
    public int minFlips(int a, int b, int c) {
        
        int count = 0;
        for (int i = 0; i < 32; i++) {
            int x = (a >> i) & 1;
            int y = (b >> i) & 1;
            int z = (c >> i) & 1;
            if (z == 1) {
                if (x == 0 && y == 0) {
                    count++;
                }
            } else {
                if (x == 1) count++;
                if (y == 1) count++;
            }
        }
        return count;
    }
}