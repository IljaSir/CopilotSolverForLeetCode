class Solution {
    public int passThePillow(int n, int time) {
        
        int direction = 1;
        int index = 0;
        while (time > 1) {
            index += direction;
            time--;
            if (index == n - 1) {
                direction = -1;
            }
            if (index == 0) {
                direction = 1;
            }
        }
        return index + 1;
    }
}