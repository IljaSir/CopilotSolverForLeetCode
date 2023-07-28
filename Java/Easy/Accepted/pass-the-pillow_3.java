class Solution {
    public int passThePillow(int n, int time) {
        
        int count = 0;
        int i = 1;
        int dir = 1;
        while (count < time) {
            if (i == n) {
                dir = -1;
            }
            if (i == 1) {
                dir = 1;
            }
            i += dir;
            count++;
        }
        return i;
    }
}