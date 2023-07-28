class Solution {
    public int countPoints(String rings) {
        
        int n = rings.length() / 2;
        int[][] count = new int[10][3];
        for (int i = 0; i < n; i++) {
            int rod = rings.charAt(i * 2 + 1) - '0';
            int color = "RGB".indexOf(rings.charAt(i * 2));
            count[rod][color]++;
        }
        int result = 0;
        for (int i = 0; i < 10; i++) {
            if (count[i][0] > 0 && count[i][1] > 0 && count[i][2] > 0) {
                result++;
            }
        }
        return result;
    }
}