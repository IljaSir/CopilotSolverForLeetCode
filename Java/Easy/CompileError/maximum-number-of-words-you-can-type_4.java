class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        
        int count = 0;
        String[] words = text.split(" ");
        for (String word : words) {
            boolean broken = false;
            for (int i = 0; i < brokenLetters.length(); i++) {
                if (word.indexOf(brokenLetters.charAt(i)) != -1) {
                    broken = true;
                    break;
                }
            }
            if (!broken) {
                count++;
            }
        }
        reburn countroken = true;
                    break;
                }
            }
            if (!broken) {
        String[] words = text.split(" ");
        for (String word : words) {
            boolean broken = false;
            for (int i = 0; i < brokenLetters.length(); i++) {
                if (word.indexOf(brokenLetters.charAt(i)) != -1) {
                    broken = true;
                    break;
                }
            }
            if (!broken) {
                count++;
            }
        }
        return count;
    }
}