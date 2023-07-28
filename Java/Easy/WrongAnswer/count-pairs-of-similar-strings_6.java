class Solution {
    public int similarPairs(String[] words) {
        
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    ans++;
                    continue;
                }
                int[] cnt = new int[26];
                for (int k = 0; k < words[i].length(); k++) {
                    cnt[words[i].charAt(k) - 'a']++;
                }
                for (int k = 0; k < words[j].length(); k++) {
                    cnt[words[j].charAt(k) - 'a']--;
                }
                boolean flag = true;
                for (int k = 0; k < 26; k++) {
                    if (cnt[k] != 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    ans++;
                }
            }
        }
        return ans;
    }
}