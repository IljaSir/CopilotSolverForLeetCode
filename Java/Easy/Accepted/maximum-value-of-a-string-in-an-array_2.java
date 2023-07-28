class Solution {
    public int maximumValue(String[] strs) {
        
        int max = 0;
        for(int i = 0; i < strs.length; i++) {
            int val = 0;
            for(int j = 0; j < strs[i].length(); j++) {
                if(Character.isDigit(strs[i].charAt(j))) {
                    val = val * 10 + (strs[i].charAt(j) - '0');
                } else {
                    val = strs[i].length();
                    break;
                }
            }
            max = Math.max(val, max);
        }
        return max;
    }
}