class Solution {
    public int countValidWords(String sentence) {
        
        int count = 0;
        String[] words = sentence.split(" ");
        for(String word: words) {
            if(word.length() == 0) continue;
            boolean valid = true;
            boolean hyphen = false;
            boolean punct = false;
            for(int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if(ch >= 'a' && ch <= 'z') continue;
                if(ch == '-') {
                    if(hyphen) {
                        valid = false;
                        break;
                    }
                    hyphen = true;
                    if(i == 0 || i == word.length() - 1) {
                        valid = false;
                        break;
                    }
                    if(word.charAt(i - 1) < 'a' || word.charAt(i - 1) > 'z') {
                        valid = false;
                        break;
                    }
                    if(word.charAt(i + 1) < 'a' || word.charAt(i + 1) > 'z') {
                        valid = false;
                        break;
                    }
                } else if(ch == '.' || ch == '!' || ch == ',') {
                    if(punct) {
                        valid = false;
                        break;
                    }
                    punct = true;
                    if(i != word.length() - 1) {
                        valid = false;
                        break;
                    }
                } else {
                    valid = false;
                    break;
                }
            }
            if(valid) count++;
        }
        return count;
    }
}