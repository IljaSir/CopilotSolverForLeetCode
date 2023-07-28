class Solution {
    public int passThePillow(int n, int time) {
        
        int dir = 1;
        int pos = 1;
        int i = 0;
        while (i < time) {
            pos += dir;
            if (pos == n || pos == 1) {
                dir *= -1;
            }
            i++;
        }
        return pos;
    }
}