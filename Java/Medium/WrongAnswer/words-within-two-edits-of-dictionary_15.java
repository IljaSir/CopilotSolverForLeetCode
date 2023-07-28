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
                        found = true;
                        break;
                    }
                } else if (word.length() + 1 == dictWord.length()) {
                    if (isOneEdit(dictWord, word)) {
                        found = true;
                        break;
                    }
                } else if (word.length() == dictWord.length() + 2) {
                    if (isTwoEdit(word, dictWord)) {
                        found = true;
                        break;
                    }
                } else if (word.length() + 2 == dictWord.length()) {
                    if (isTwoEdit(dictWord, word)) {
                        found = true;
                        break;
                    }
                }
            }
            if (found) {
                result.add(word);
            }
        }
        return result;
    }
    private boolean isOneEdit(String word, String dictWord) {
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < word.length() && j < dictWord.length()) {
            if (word.charAt(i) != dictWord.charAt(j)) {
                count++;
                if (count > 1) {
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
        return true;
    }
}