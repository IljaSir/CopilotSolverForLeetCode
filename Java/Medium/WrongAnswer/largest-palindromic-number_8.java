class Solution {
    public String largestPalindromic(String num) {
        
        char[] arr = num.toCharArray();
        Arrays.sort(arr);
        int[] count = new int[10];
        for (char c : arr) {
            count[c - '0']++;
        }
        int[] ans = new int[arr.length];
        int i = 0;
        for (int j = 9; j >= 0; j--) {
            while (count[j] > 0) {
                ans[i++] = j;
                count[j]--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < ans.length; j++) {
            sb.append(ans[j]);
        }
        return sb.toString();
    }
}