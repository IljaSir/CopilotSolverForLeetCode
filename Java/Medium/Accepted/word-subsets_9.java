class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        
        List<String> ans = new ArrayList<>();
        int[] count2 = count("");
        for (String word : words2) {
            int[] count = count(word);
            for (int i = 0; i < 26; i++) {
                count2[i] = Math.max(count2[i], count[i]);
            }
        }
        search: for (String word : words1) {
            int[] count = count(word);
            for (int i = 0; i < 26; i++) {
                if (count[i] < count2[i]) {
                    continue search;
                }
            }
            ans.add(word);
        }
        return ans;
    }
    
    public int[] count(String word) {
        int[] ans = new int[26];
        for (char c : word.toCharArray()) {
            ans[c - 'a']++;
        }
        return ans;
    }
}