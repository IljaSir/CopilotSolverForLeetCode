class Solution {
    public int[] shortestToChar(String s, char c) {
        
        int[] result = new int[s.length()];
        int[] cIndex = new int[s.length()];
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                cIndex[index] = i;
                index++;
            }
        }
        int[] cIndex2 = new int[index];
        for (int i = 0; i < index; i++) {
            cIndex2[i] = cIndex[i];
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                result[i] = 0;
            } else {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < cIndex2.length; j++) {
                    int tmp = Math.abs(cIndex2[j] - i);
                    if (tmp < min) {
                        min = tmp;
                    }
                }
                result[i] = min;
            }
        }
        return result;
    }
}