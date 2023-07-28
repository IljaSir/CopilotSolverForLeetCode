class Solution {
    public int repeatedStringMatch(String a, String b) {
        
        int count = 0;
        String temp = "";
        while (temp.length() < b.length()) {
            temp += a;
            count++;
        }
        if (temp.indexOf(b) >= 0) {
            return count;
        }
        if ((temp + a).indexOf(b) >= 0) {
            return count + 1;
        }
        return -1;
    }
}