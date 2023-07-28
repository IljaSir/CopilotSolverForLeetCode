class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        
        int n = s.length();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.charAt(i) - 'a';
        }
        int sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum += shifts[i][2];
            arr[i] = (arr[i] + sum) % 26;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append((char) ('a' + arr[i]));
        }
        return sb.toString();
    }
}