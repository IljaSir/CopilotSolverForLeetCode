class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int[] counts = new int[26];
        for (char c : tasks) {
            counts[c - 'A']++;
        }
        Arrays.sort(counts);
        int max = counts[25];
        int maxCount = 1;
        for (int i = 24; i >= 0; i--) {
            if (counts[i] == max) {
                maxCount++;
            } else {
                break;
            }
        }
        int partCount = max - 1;
        int partLength = n - (maxCount - 1);
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.length - max * maxCount;
        int idles = Math.max(0, emptySlots - availableTasks);
        return tasks.length + idles;
    }
}