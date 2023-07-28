class Solution {
    public int[] diStringMatch(String s) {
        
        int[] res = new int[s.length() + 1];
        int low = 0;
        int high = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                res[i] = low++;
            } else {
                res[i] = high--;
            }
        }
        res[s.length()] = low;
        return res;
    }
}