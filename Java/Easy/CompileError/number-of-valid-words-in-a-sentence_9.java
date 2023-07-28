class Solution {
    public int countValidWords(String sentence) {
        
        int count = 0;
        String[] words = sentence.split(" ");
        for(String word : words) {
            if(word.length() > 0) {
                boolean valid = true;
                boolean hyphen = false;
                boolean punctuation = false;
                for(int i = 0; i < word.length(); i++) {
                    char ch = word.charAt(i);
                    if(ch == '-') {
                        if(i == 0 || i == word.length() - 1) {
                            valid = false;
                            break;
                        } else if(hyphen) {
                            valid = false;
                            break;
                        } else {
                            hyphen = true;
                        }
                    } else if(ch == '!' || ch == '.' || ch == ',') {
                        if(i != word.length() - 1) {
                            valid = false;
                            break;
                        } else if(punctuation) {
                            valid = false;
                            break;
                        } else {
                            punctuation = true;
                        }
                    } else if(ch >= 'a' && ch <= 'z') {
                        // do nothing
                    } else {
                        valid = false;
                        break;
                    }
                }
                if(valid) {
                    count++;
                }
            }
                if (c == '-') {
                    if (hyphen) {
                        valid = false;
                        break;
                    }
                    hyphen = true;
                    if (i == 0 || i == word.length() - 1) {
                        valid = false;
                        break;
                    }
                    if (!Character.isLowerCase(word.charAt(i - 1)) || !Character.isLowerCase(word.charAt(i + 1))) {
                        valid = false;
                        break;
                    }
                }
                if (c == '!' || c == '.' || c == ',') {
                    if (punctuation) {
                        valid = false;
                        break;
                    }
                    punctuation = true;
                    if (i != word.length() - 1) {
                        valid = false;
                        break;
                    }
                }
            }
            if (valid) {
                count++;
            }
        }
        return count;
    }
}