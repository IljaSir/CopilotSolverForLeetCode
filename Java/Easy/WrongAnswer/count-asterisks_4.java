class Solution {
    public int countAsterisks(String s) {
        
        int count = 0;
        boolean flag = false;
        for (char c : s.toCharArray()) {
            if (c == '*') {
                if (flag) {
                    count++;
                    flag = false;
                } else {
                    flag = true;
                }
            } else {
                flag = false;
            }
        }
        return count;
    }
}