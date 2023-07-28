class Solution {
    public int maxDiff(int num) {
        
        int min = num, max = num;
        char[] c = String.valueOf(num).toCharArray();
        for (int i = 0; i < c.length; i++) {
            char x = c[i];
            if (x != '9') {
                max = Math.max(max, Integer.parseInt(String.valueOf(c).replace(x, '9')));
            }
            if (x != '1' && i > 0 || x > '1' && i == 0) {
                min = Math.min(min, Integer.parseInt(String.valueOf(c).replace(x, '1')));
            }
        }
        return max - min;
    }
}