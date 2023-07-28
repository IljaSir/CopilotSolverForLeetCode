class Solution {
    public String reformat(String s) {
        
        char[] chars = s.toCharArray();
        int n = s.length();
        int[] counts = new int[2];
        for (char c : chars) {
            counts[Character.isDigit(c) ? 1 : 0]++;
        }
        int max = Math.max(counts[0], counts[1]);
        int min = Math.min(counts[0], counts[1]);
        if (max - min > 1) {
            return "";
        }
        int i = 0;
        int j = 1;
        if (counts[0] < counts[1]) {
            i = 1;
            j = 0;
        }
        char[] result = new char[n];
        for (char c : chars) {
            if (Character.isDigit(c) == (i == 0)) {
                result[i] = c;
                i += 2;
            } else {
                result[j] = c;
                j += 2;
            }
        }
        return new String(result);
    }
}