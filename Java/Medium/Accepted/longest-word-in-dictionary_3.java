class Solution {
    public String longestWord(String[] words) {
        
        String ans = "";
        Set<String> wordsSet = new HashSet();
        for (String word : words) {
            wordsSet.add(word);
        }
        for (String word : words) {
            if (word.length() > ans.length() || (word.length() == ans.length() && word.compareTo(ans) < 0)) {
                boolean good = true;
                for (int k = 1; k < word.length(); ++k) {
                    if (!wordsSet.contains(word.substring(0, k))) {
                        good = false;
                        break;
                    }
                }
                if (good) {
                    ans = word;
                }
            }
        }
        return ans;
    }
}