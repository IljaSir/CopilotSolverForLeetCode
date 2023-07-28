class Solution {
    public int[] diStringMatch(String s) {
        
        int[] result = new int[s.length() + 1];
        int left = 0;
        int right = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                result[i] = left;
                left++;
            } else {
                result[i] = right;
                right--;
            }
        }
        result[s.length()] = left;
        return result;
    }
}