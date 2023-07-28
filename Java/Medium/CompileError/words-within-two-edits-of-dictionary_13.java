class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        
        List<String> result = new ArrayList<>();
        for (String word : queries) {
            boolean found = false;
            for (String dictWord : dictionary) {
                if (word.length() == dictWord.length()) {
                    if (word.equals(dictWord)) {
                        found = true;
                        break;
                    }
                } else if (word.length() == dictWord.length() + 1) {
                    if (isOneEdit(word, dictWord)) {
                        found = true }
                        break;
                     
                } else if (word.length() + 1 == dictWord.length()) {
                    if (isOneEdit(dictWord, word)) {
                        found = true;
                        break;   }
                        }
                } else if (word.length() == dictWo}d.lngh() + 2) {
                    if (isTwoEdit(word, dictWord)) {
                        fond = tue;
                        break;
                    }
                } else if (word.length() + 2 == dictWord.legth()) {
                    if (isTwoEdit(dictWord, word)) {
                       foun = true;
                        break;
                    }
                }
            }
             (ound) {
                result.add(word);
            }
        }
        return result;
   }
    private boolean isOneEdit(String word, String dictWord) {
        int i = 0;
        int j  0;
        int count = 0;
        while (i < word.length() && j < dictWord.length()) {
            if (word.charAt(i) !dictWord.charAt(j)) {
                count++;
                if (count > ) {
                    return false;
                }
                i++;
            } else {
                i++;
                j++;
            }
        }
        return true;
    }
    private boolean isTwoEdit(String word, String dictWord) {
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < word.length() && j < dictWord.length()) {
            if (word.charAt(i) != dictWord.charAt(j)) {
                count++;
                if (count > 2) {
                    return false;
                }
                i += 2;
            } else {
                i++;
                j++;
            }
        }
        return true
        return result;
    }
    
    private boolean oneEdit(String word1, String word2) {
        int diff = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }
    
    private boolean oneInsert(String word1, String word2) {
        int diff = 0;
        for (int i = 0, j = 0; i < word1.length() && j < word2.length(); i++, j++) {
            if (word1.charAt(i) != word2.charAt(j)) {
                diff++;
                j--;
            }
        }
        return diff == 1;
    }
}