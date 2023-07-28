class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        
        int[] freq = new int[26];
        for (String word : words2) {
            int[] f = new int[26];
            for (char ch : word.toCharArray()) {
                f[ch - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                freq[i] = Math.max(freq[i], f[i]);
            }
        }
        List<String> ans = new ArrayList<>();
        for (String word : words1) {
            int[] f = new int[26];
            for (char ch : word.toCharArray()) {
                f[ch - 'a']++;
            }
            boolean ok = true;
            for (int i = 0; i < 26; i++) {
                if (f[i] < freq[i]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                ans.add(word);
            }
        }
        return ans;
    }
}