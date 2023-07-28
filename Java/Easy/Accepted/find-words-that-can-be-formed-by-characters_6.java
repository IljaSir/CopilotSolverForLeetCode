class Solution {
    public int countCharacters(String[] words, String chars) {
        
        int[] count = new int[26];
        for (char c: chars.toCharArray()) {
            count[c - 'a']++;
        }
        int ans = 0;
        search:
        for (String word: words) {
            int[] count1 = new int[26];
            for (char c: word.toCharArray()) {
                count1[c - 'a']++;
            }
            for (int i = 0; i < 26; ++i) {
                if (count1[i] > count[i]) {
                    continue search;
                }
            }
            ans += word.length();
        }
        return ans;
    }
}