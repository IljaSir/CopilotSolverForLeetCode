class Solution {
    public int numTilePossibilities(String tiles) {
        
        int n = tiles.length();
        int[] cnt = new int[26];
        for (char c : tiles.toCharArray()) {
            cnt[c - 'A']++;
        }
        return dfs(cnt);
    }
    
    private int dfs(int[] cnt) {
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] == 0) continue;
            ans++;
            cnt[i]--;
            ans += dfs(cnt);
            cnt[i]++;
        }
        return ans;
    }
}