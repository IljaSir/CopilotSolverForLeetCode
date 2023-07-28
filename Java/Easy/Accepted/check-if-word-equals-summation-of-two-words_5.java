class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        
        return getNumber(firstWord) + getNumber(secondWord) == getNumber(targetWord);
    }
    
    private int getNumber(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            sb.append((int)(word.charAt(i) - 'a'));
        }
        return Integer.valueOf(sb.toString());
    }
}