class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }
        Arrays.sort(count);
        int maxVal = count[25] - 1;
        int idleSlots = maxVal * n;
        for (int i = 24; i >= 0 && count[i] > 0; i--) {
            idleSlots -= Math.min(count[i], maxVal);
        }
        return idleSlots > 0 ? idleSlots + tasks.length : tasks.length;
    }
}