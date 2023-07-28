class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        
        HashSet<String> bannedSet = new HashSet<>();
        for (String word: banned) {
            bannedSet.add(word);
        }
        HashMap<String, Integer> wordCount = new HashMap<>();
        int maxCount = 0;
        String maxWord = "";
        String[] words = paragraph.split("[ !?',;.]+");
        for (String word: words) {
            word = word.toLowerCase();
            if (!bannedSet.contains(word)) {
                int count = wordCount.getOrDefault(word, 0) + 1;
                if (count > maxCount) {
                    maxCount = count;
                    maxWord = word;
                }
                wordCount.put(word, count);
            }
        }
        return maxWord;
    }
}