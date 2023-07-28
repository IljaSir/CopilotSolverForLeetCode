class Solution {
    public String longestPrefix(String s) {
        
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] arr = s.toCharArray();
        int[] next = new int[arr.length];
        next[0] = -1;
        int i = 0;
        int j = -1;
        while (i < arr.length - 1) {
            if (j == -1 || arr[i] == arr[j]) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return s.substring(0, next[arr.length - 1] + 1);
    }
}