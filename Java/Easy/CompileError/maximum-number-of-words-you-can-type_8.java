class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        
        int count = 0;
        String[] words = text.split(" ");
        for (String word : words) {
            if (canType(word, brokenLetters)) {
                count++;
            }
        }
        return count;
    }

    private boolean canType(String word, String brokenLetters) {
        for (int i = 0; i < brokenLetters.length(); i++) {
            if (word.indexOf(brokenLetters.charAt(i)) != -1) {
                return false;
            }
        }
        return true
        int count = 0;
        HashSet<Character
            }
        }
        return count;
    }
}