class Solution {
    public int uniqueLetterString(String s) {
        
        int n = s.length();
        int[] last = new int[26];
        int[] count = new int[26];
        int[] pos = new int[26];
        Arrays.fill(last, -1);
        Arrays.fill(pos, -1);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int ch = s.charAt(i) - 'A';
            ans += (i - last[ch]) * (last[ch] - pos[ch]);
            pos[ch] = last[ch];
            last[ch] = i;
            count[ch]++;
        }
        for (int i = 0; i < 26; i++) {
            ans += (n - last[i]) * (last[i] - pos[i]);
        }
        return ans;
    }
}