class Solution {
    public long wonderfulSubstrings(String word) {
        
        int[] seen = new int[1024];
        seen[0] = 1;
        int mask = 0;
        long ans = 0;
        for (char c : word.toCharArray()) {
            mask ^= 1 << (c - 'a');
            ans += seen[mask];
            for (int i = 0; i < 10; i++) {
                ans += seen[mask ^ (1 << i)];
            }
            seen[mask]++;
        }
        return ans;
    }
}