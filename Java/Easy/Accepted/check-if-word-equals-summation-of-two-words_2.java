class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        
        int first = 0;
        int second = 0;
        int target = 0;
        for (int i = 0; i < firstWord.length(); i++) {
            first = first * 10 + (firstWord.charAt(i) - 'a');
        }
        for (int i = 0; i < secondWord.length(); i++) {
            second = second * 10 + (secondWord.charAt(i) - 'a');
        }
        for (int i = 0; i < targetWord.length(); i++) {
            target = target * 10 + (targetWord.charAt(i) - 'a');
        }
        return first + second == target;
    }
}