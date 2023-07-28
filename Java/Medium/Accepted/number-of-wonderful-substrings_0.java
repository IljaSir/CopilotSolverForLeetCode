class Solution {
    public long wonderfulSubstrings(String word) {
        
        long ans = 0;
        int[] count = new int[1024];
        count[0] = 1;
        int mask = 0;
        for (int i = 0; i < word.length(); i++) {
            mask ^= 1 << (word.charAt(i) - 'a');
            ans += count[mask];
            for (int j = 0; j < 10; j++) {
                ans += count[mask ^ (1 << j)];
            }
            count[mask]++;
        }
        return ans;
    }
}