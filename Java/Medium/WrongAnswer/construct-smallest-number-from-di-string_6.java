class Solution {
    public String smallestNumber(String pattern) {
        
        int[] result = new int[pattern.length()+1];
        int max = pattern.length();
        int min = 1;
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == 'I') {
                result[i] = min;
                min++;
            } else {
                result[i] = max;
                max--;
            }
        }
        result[pattern.length()] = min;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]);
        }
        return sb.toString();
    }
}