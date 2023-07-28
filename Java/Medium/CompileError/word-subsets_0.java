class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        
        int[] maxFreq = new int[26];
        for (String word: words2) {
            int[] freq = count(word);
            for (int i = 0; i < 26; ++i)
                maxFreq[i] = Math.max(maxFreq[i], freq[i]);
        }

        List<String> ans = new ArrayList();
        search:
        for (String word: words1) {
            int[] freq = count(word);
            for (int i = 0; i < 26; ++i)
                if (freq[i] < maxFreq[i])
                    continue search;
            ans.add(word);
        }

        return ans;
    }
}