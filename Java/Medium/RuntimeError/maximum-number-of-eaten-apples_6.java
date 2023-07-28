class Solution {
    public int eatenApples(int[] apples, int[] days) {
        
        int n = apples.length;
        int maxDays = 0;
        for (int i = 0; i < n; i++) {
            maxDays = Math.max(maxDays, i + days[i]);
        }
        int[] applesCount = new int[maxDays + 1];
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j < i + days[i]) {
                applesCount[j]++;
                j++;
            }
        }
        int count = 0;
        for (int i = 0; i < maxDays; i++) {
            if (applesCount[i] > 0 && apples[i] > 0) {
                count++;
                applesCount[i]--;
                apples[i]--;
            }
        }
        return count;
    }
}