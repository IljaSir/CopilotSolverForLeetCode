class Solution {
    public int minDeletions(String s) {
        
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        Arrays.sort(freq);
        int n = s.length();
        int ans = 0;
        for (int i = 25; i >= 0; i--) {
            if (freq[i] == 0) {
                continue;
            }
            int j = i - 1;
            while (j >= 0 && freq[j] >= freq[i]) {
                if (freq[j] == freq[i]) {
                    freq[j]--;
                    ans++;
                }
                j--;
            }
        }
        return ans;
    }
}