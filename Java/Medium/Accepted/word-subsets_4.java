class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        
        int[] count = new int[26];
        for (String word: words2) {
            int[] temp = new int[26];
            for (char c: word.toCharArray()) {
                temp[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                count[i] = Math.max(count[i], temp[i]);
            }
        }
        List<String> ans = new ArrayList();
        search:
        for (String word: words1) {
            int[] temp = new int[26];
            for (char c: word.toCharArray()) {
                temp[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (temp[i] < count[i]) {
                    continue search;
                }
            }
            ans.add(word);
        }
        return ans;
    }
}