class Solution {
    public int fillCups(int[] amount) {
        
        int cold = amount[0];
        int warm = amount[1];
        int hot = amount[2];
        int time = 0;
        while (cold > 0 || warm > 0 || hot > 0) {
            if (cold > 0 && warm > 0) {
                cold--;
                warm--;
                time++;
            } else if (warm > 0 && hot > 0) {
                warm--;
                hot--;
                time++;
            } else if (hot > 0 && cold > 0) {
                cold--;
                hot--;
                time++;
            } else if (cold > 0) {
                cold--;
                time++;
            } else if (warm > 0) {
                warm--;
                time++;
            } else if (hot > 0) {
                hot--;
                time++;
            }
        }
        return time;
    }
}