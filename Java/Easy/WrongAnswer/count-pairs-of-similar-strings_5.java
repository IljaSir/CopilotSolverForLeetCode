class Solution {
    public int similarPairs(String[] words) {
        
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isSimilar(words[i], words[j])) ans++;
            }
        }
        return ans;
    }
    boolean isSimilar(String a, String b) {
        if (a.length() != b.length()) return false;
        int[] cnt = new int[26];
        for (int i = 0; i < a.length(); i++) {
            cnt[a.charAt(i) - 'a']++;
        }
        for (int i = 0; i < b.length(); i++) {
            cnt[b.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (cnt[i] != 0) return false;
        }
        return true;
    }
}