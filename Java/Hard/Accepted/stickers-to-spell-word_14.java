class Solution {
    public int minStickers(String[] stickers, String target) {
        
        int n = stickers.length;
        int[][] count = new int[n][26];
        for (int i = 0; i < n; i++) {
            for (char c : stickers[i].toCharArray()) {
                count[i][c - 'a']++;
            }
        }
        Map<String, Integer> dp = new HashMap<>();
        dp.put("", 0);
        return helper(dp, count, target);
    }
    
    private int helper(Map<String, Integer> dp, int[][] count, String target) {
        if (dp.containsKey(target)) {
            return dp.get(target);
        }
        int ans = Integer.MAX_VALUE, n = count.length;
        int[] tar = new int[26];
        for (char c : target.toCharArray()) {
            tar[c - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            if (count[i][target.charAt(0) - 'a'] == 0) {
                continue;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                if (tar[j] > 0) {
                    for (int k = 0; k < Math.max(0, tar[j] - count[i][j]); k++) {
                        sb.append((char)(j + 'a'));
                    }
                }
            }
            String s = sb.toString();
            int tmp = helper(dp, count, s);
            if (tmp != -1) {
                ans = Math.min(ans, 1 + tmp);
            }
        }
        dp.put(target, ans == Integer.MAX_VALUE ? -1 : ans);
        return dp.get(target);
    }
}