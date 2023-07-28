class Solution {
    public int countPoints(String rings) {
        
        int result = 0;
        int[] count = new int[10];
        for (int i = 0; i < rings.length(); i += 2) {
            count[rings.charAt(i + 1) - '0']++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] >= 3) {
                result++;
            }
        }
        return result;
    }
}