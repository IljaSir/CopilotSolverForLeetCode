class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        
        int[] max = new int[26];
        for (String word2 : words2) {
            int[] count = new int[26];
            for (char c : word2.toCharArray()) {
                count[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                max[i] = Math.max(max[i], count[i]);
            }
        }
        List<String> ans = new ArrayList<>();
        for (String word1 : words1) {
            int[] count = new int[26];
            for (char c : word1.toCharArray()) {
                count[c - 'a']++;
            }
            boolean flag = true;
            for (int i = 0; i < 26; i++) {
                if (count[i] < max[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans.add(word1);
            }
        }
        return ans;
    }
}