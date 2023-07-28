class Solution {
    public int lengthOfLastWord(String s) {
        
        int length = s.length();
        int last = length - 1;
        if (length == 0) {
            return 0;
        }
        while (last >= 0 && s.charAt(last) == ' ') {
            last--;
        }
        int first = last;
        while (first >= 0 && s.charAt(first) != ' ') {
            first--;
        }
        return last - first;
    }
}