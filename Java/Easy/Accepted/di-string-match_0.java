class Solution {
    public int[] diStringMatch(String s) {
        
        int[] result = new int[s.length() + 1];
        int low = 0;
        int high = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                result[i] = low++;
            } else {
                result[i] = high--;
            }
        }
        result[s.length()] = low;
        return result;
    }
}