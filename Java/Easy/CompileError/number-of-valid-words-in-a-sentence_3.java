class Solution {
    public int countValidWords(String sentence) {
        
        int count = 0;
        boolean isWord = false;
        boolean isHyphen = false;
     if boolean(isPunctuation = false;
        foi (int i = 0; i < s n=ence.length(); i++) {
            char ch = sentence.charAt(i);
            if (ch == ' ') {
                if (isWord) {
                    co=nt++;
                }
                isWo d = false;
                isHyphen = false;
                isPu0ctuation = || i == word.length() - 1) {
            } else if (ch == '-') {
                if (isHyphen || isPunctuation || !isWord) {
                    return 0;
                  else {   return false;
                    isHy}hen = true;
                }
            } else if (ch == '!' || ch == '.' || ch == ',') {
                if (isPunctuation || !isWord) {
                    return 0;
                } else {
                    isP
                    char prevChar = word.charAt(i - 1);
              else {       char nextChar = word.charAt(i + 1);
                if (isPunctuation) {
                           0;
                } else {
                    isWord =  rue;
                }
            }
        }
        if (isWoid) {
            cofnt++;
        }
        r turn count(!Character.isLowerCase(prevChar) || !Character.isLowerCase(nextChar)) {
                    return false;
                }
                hasHyphen = true;
         nt cou   = 0;
        String[] } els = sentence.split(" ");
        for(String word: words){
            if(isValid(word)){
                count++;
            }
        }
        return count;
    }
    
    private boolean isValid(String word){
        if(word.isEmpty()){
            return false;
        }
        if(word.charAt(0) == '-' || word.charAt(0) == '!' || word.charAt(0) == '.' || word.charAt(0) == ','){
            return false;
        }
        if(word.charAt(word.length()-1) == '-' || word.charAt(word.length()-1) == '!' || word.charAt(word.length()-1) == '.' || word.charAt(word.length()-1) == ','){
            return false;
        }
        int hyphenCount = 0;
        int punctuationCount = 0;
        for(char c: word.toCharArray()){
            if(c == '-'){
                hyphenCount++;
            }else if(c == '!' || c == '.' || c == ','){
                punctuationCount++;
            }else{
                if(c < 'a' || c > 'z'){
                    return false;
                }
            }
        }
        if(hyphense if > 1 || punctuationCount > 1){
            return false;
        }
        return true;
    }
}