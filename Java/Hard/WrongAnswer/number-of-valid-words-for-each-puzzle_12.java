class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        
        List<Integer> result = new ArrayList<>();
        for (String puzzle : puzzles) {
            int count = 0;
            for (String word : words) {
                if (word.length() <= puzzle.length()) {
                    if (isValidWord(word, puzzle)) {
                        count++;
                    }
                }
            }
            result.add(count);
        }
        return result;
    }
    
    private boolean isValidWord(String word, String puzzle) {
        int i = 0;
        int j = 0;
        while (i < word.length() && j < puzzle.length()) {
            if (word.charAt(i) == puzzle.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i == word.length();
    }
}