class Solution {
    public String reverseStr(String s, int k) {
        
        char[] chars = s.toCharArray();
        int n = s.length();
        for (int i = 0; i < n; i += 2 * k) {
            int left = i, right = Math.min(i + k, n) - 1;
            while (left < right) {
                char tmp = chars[left];
                chars[left] = chars[right];
                chars[right] = tmp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }
}