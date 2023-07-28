class Solution {
    public int longestPalindrome(String s) {
        
        int[] arr = new int[128];
        for (char c : s.toCharArray()) {
            arr[c]++;
        }
        int sum = 0;
        for (int i : arr) {
            sum += i / 2 * 2;
            if (sum % 2 == 0 && i % 2 == 1) {
                sum++;
            }
        }
        return sum;
    }
}