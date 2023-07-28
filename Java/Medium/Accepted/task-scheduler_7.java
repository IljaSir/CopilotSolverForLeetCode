class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int[] map = new int[26];
        int max = 0;
        int maxCount = 0;
        for (char c : tasks) {
            map[c - 'A']++;
            if (map[c - 'A'] > max) {
                max = map[c - 'A'];
                maxCount = 1;
            } else if (map[c - 'A'] == max) {
                maxCount++;
            }
        }
        return Math.max((max - 1) * (n + 1) + maxCount, tasks.length);
    }
}