class Solution {
    public int secondHighest(String s) {
        
        int[] arr = new int[10];
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                arr[ch - '0']++;
            }
        }
        int count = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > 0) {
                count++;
            }
            if (count == 2) {
                return i;
            }
        }
        return -1;
    }
}