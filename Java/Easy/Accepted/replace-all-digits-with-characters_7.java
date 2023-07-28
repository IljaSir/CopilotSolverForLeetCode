class Solution {
    public String replaceDigits(String s) {
        
        char[] sArray = s.toCharArray();
        for (int i = 1; i < s.length(); i+=2) {
            sArray[i] = (char) (sArray[i-1] + sArray[i] - '0');
        }
        return new String(sArray);
    }
}