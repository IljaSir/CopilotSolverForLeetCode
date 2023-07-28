class Solution {
    public int repeatedStringMatch(String a, String b) {
        
        int count = 1;
        String temp = a;
        while (temp.length() < b.length()) {
            temp += a;
            count++;
        }
        if (temp.contains(b)) {
            return count;
        }
        temp += a;
        if (temp.contains(b)) {
            return count + 1;
        }
        return -1;
    }
}