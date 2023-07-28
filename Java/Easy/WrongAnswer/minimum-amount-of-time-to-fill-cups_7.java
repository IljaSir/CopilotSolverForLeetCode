class Solution {
    public int fillCups(int[] amount) {
        
        int totalAmount = 0;
        for (int i = 0; i < amount.length; i++) {
            totalAmount += amount[i];
        }
        int cold = amount[0];
        int warm = amount[1];
        int hot = amount[2];
        int min = Math.min(cold, Math.min(warm, hot));
        int max = Math.max(cold, Math.max(warm, hot));
        int mid = cold + warm + hot - min - max;
        int time = 0;
        if (min == max) {
            time = min * 2;
        } else if (min == mid) {
            time = min * 2 + 1;
        } else if (mid == max) {
            time = min * 2 + 1;
        } else if (min < mid) {
            time = min * 2 + mid - min;
        } else if (mid < max) {
            time = min * 2 + max - mid;
        }
        return time;
    }
}