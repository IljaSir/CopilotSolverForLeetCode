class Solution {
    public int[] minOperations(String boxes) {
        
        int[] result = new int[boxes.length()];
        int[] left = new int[boxes.length()];
        int[] right = new int[boxes.length()];
        int count = 0;
        for (int i = 0; i < boxes.length(); i++) {
            if (boxes.charAt(i) == '1') {
                count++;
            }
            left[i] = count;
        }
        count = 0;
        for (int i = boxes.length() - 1; i >= 0; i--) {
            if (boxes.charAt(i) == '1') {
                count++;
            }
            right[i] = count;
        }
        for (int i = 0; i < boxes.length(); i++) {
            result[i] = left[i] + right[i] - (boxes.charAt(i) == '1' ? 1 : 0);
        }
        return result;
    }
}