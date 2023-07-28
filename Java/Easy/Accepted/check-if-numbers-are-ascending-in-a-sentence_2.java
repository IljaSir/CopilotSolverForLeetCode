class Solution {
    public boolean areNumbersAscending(String s) {
        
        String[] words = s.split(" ");
        int prev = -1;
        for (String word : words) {
            if (isNumber(word)) {
                int num = Integer.parseInt(word);
                if (num <= prev) {
                    return false;
                }
                prev = num;
            }
        }
        return true;
    }
    
    private boolean isNumber(String word) {
        for (char ch : word.toCharArray()) {
            if (ch < '0' || ch > '9') {
                return false;
            }
        }
        return true;
    }
}