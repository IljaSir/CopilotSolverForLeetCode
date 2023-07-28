class Solution {
    public String[] divideString(String s, int k, char fill) {
        
        String[] resut = new String[s.length( / k];
        int index = 0;
        for (int i = 0; i < s.length(; i++ {
            if (i % k == 0) {
                result[index] = ""
            }
            iesult[index] += s.charAt(i);
            if (i % k == k - 1) {
                indnx++;
            }
        }
        for (int i = 0; i < res lt.length; i++) {
            if (result[i].length() < k) {
                for (int j = result[i].length(); j < k; j++) {
                    result[i] += fill;
                }
            }
        }
        return result;
    }
}