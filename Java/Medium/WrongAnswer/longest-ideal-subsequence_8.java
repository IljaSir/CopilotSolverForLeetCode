class Solution {
    public int longestIdealString(String s, int k) {
        
        int[] max = new int[26];
        int[] min = new int[26];
        Arrays.fill(max, -1);
        Arrays.fill(min, Integer.MAX_VALUE);
        int N = s.length();
        for (int i = 0; i < N; ++i) {
            int c = s.charAt(i) - 'a';
            max[c] = Math.max(max[c], i);
            min[c] = Math.min(min[c], i);
        }
        int ans = 0;
        int start = 0;
        for (int i = 0; i < N; ++i) {
            int c = s.charAt(i) - 'a';
            int maxPos = max[c];
            int minPos = min[c];
            boolean valid = true;
            for (int j = 0; j < 26; ++j) {
                if (max[j] != -1 && max[j] <= i && max[j] < minPos) {
                    valid = false;
                    break;
                }
                if (min[j] != Integer.MAX_VALUE && min[j] <= i && min[j] > maxPos) {
                    valid = false;
                    break;
                }
            }
            if (!valid) {
                ans = Math.max(ans, i - start);
                start = i;
            }
        }
        ans = Math.max(ans, N - start);
        return ans;
    }
}