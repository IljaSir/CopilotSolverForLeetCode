class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        
        int[] target = new int[26];
        for (String w : words2) {
            int[] count = new int[26];
            for (char c : w.toCharArray()) {
                count[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                target[i] = Math.max(target[i], count[i]);
            }
        }

        List<String> ans = new ArrayList();
        search:
        for (String w : words1) {
            int[] count = new int[26];
            for (char c : w.toCharArray()) {
                count[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (count[i] < target[i]) {
                    continue search;
                }
            }
            ans.add(w);
        }

        return ans;
    }
}