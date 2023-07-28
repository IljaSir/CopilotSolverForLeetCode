class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        
        Arrays.sort(banned);
        int count = 0;
        for (int i = 0; i < banned.length; i++) {
            if (banned[i] > maxSum) {
                break;
            }
            int j = i;
            while (j + 1 < banned.length && banned[j + 1] == banned[i]) {
                j++;
            }
            int x = banned[i];
            int y = j + 1 < banned.length ? banned[j + 1] : n + 1;
            int cnt = Math.max(0, Math.min(y - 1, maxSum - x) - x + 1);
            count += cnt;
            maxSum -= cnt;
            i = j;
        }
        return count;
    }
}