class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        
        int[] max = new int[26];
        for (String word : words2) {
            int[] count = count(word);
            for (int i = 0; i < 26; i++) {
                max[i] = Math.max(max[i], count[i]);
            }
        }
        List<String> ans = new ArrayList();
        search: for (String word : words1) {
            int[] count = count(word);
            for (int i = 0; i < 26; i++) {
                if (count[i] < max[i]) {
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