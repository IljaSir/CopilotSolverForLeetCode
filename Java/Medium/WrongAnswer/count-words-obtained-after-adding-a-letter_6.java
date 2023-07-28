class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        
        int count = 0;
        Set<String> wordSet = new HashSet<>();
        for (String word : startWords) {
            wordSet.add(word);
        }
        for (String word : targetWords) {
            if (wordSet.contains(word)) {
                count++;
                continue;
            }
            boolean flag = false;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (ch == c) {
                        continue;
                    }
                    StringBuilder sb = new StringBuilder(word);
                    sb.insert(i, ch);
                    if (wordSet.contains(sb.toString())) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
            }
            if (flag) {
                count++;
            }
        }
        return count;
    }
}