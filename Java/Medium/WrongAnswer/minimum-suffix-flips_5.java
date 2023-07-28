class Solution {
    public int minFlips(String target) {
        
        int count = 0;
        char[] chars = target.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') {
                count++;
                while (i < chars.length && chars[i] == '1') {
                    i++;
                }
                i--;
            }
        }
        return count;
    }
}