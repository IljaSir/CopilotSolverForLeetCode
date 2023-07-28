class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        
        return getVal(firstWord) + getVal(secondWord) == getVal(targetWord);
    }
    private int getVal(String s) {
        int res = 0;
        for (char c : s.toCharArray()) {
            res = res * 10 + (c - 'a');
        }
        return res;
    }
}