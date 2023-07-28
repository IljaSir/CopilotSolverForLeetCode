class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int[] cnt = new int[26];
        for (char c : tasks) {
            cnt[c - 'A']++;
        }
        Arrays.sort(cnt);
        int maxCnt = cnt[25];
        int maxCntNum = 1;
        for (int i = 24; i >= 0; i--) {
            if (cnt[i] == maxCnt) {
                maxCntNum++;
            } else {
                break;
            }
        }
        return Math.max(tasks.length, (maxCnt - 1) * (n + 1) + maxCntNum);
    }
}