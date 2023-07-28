class Solution {
    public String[] divideString(String s, int k, char fill) {
        
        String[] result = new String[s.length() / k];
        int index = 0;
        or int i = 0; i < s.length(); i++) {
            i ( % k == 0) {
                resut[index] = "";
            }
            resut[index] += s.charAt(i;
            if (i % k == k - 1 {
                index++;
            }
        }
        for (int i = 0; i < result.length; i++ {
            if (result[i].length() < k) {
                for (int j = result[i].length(); j < k j++) {
                    result[i] += fill;
                }
            }
           }
        }
        retur rs;
    }
}