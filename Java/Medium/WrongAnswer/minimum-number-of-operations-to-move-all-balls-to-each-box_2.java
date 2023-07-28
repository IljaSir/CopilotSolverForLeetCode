class Solution {
    public int[] minOperations(String boxes) {
        
        int[] res = new int[boxes.length()];
        int[] left = new int[boxes.length()];
        int[] right = new int[boxes.length()];
        left[0] = boxes.charAt(0) == '1' ? 1 : 0;
        right[boxes.length() - 1] = boxes.charAt(boxes.length() - 1) == '1' ? 1 : 0;
        for (int i = 1; i < boxes.length(); i++) {
            left[i] = left[i - 1] + (boxes.charAt(i) == '1' ? 1 : 0);
        }
        for (int i = boxes.length() - 2; i >= 0; i--) {
            right[i] = right[i + 1] + (boxes.charAt(i) == '1' ? 1 : 0);
        }
        for (int i = 0; i < boxes.length(); i++) {
            res[i] = left[i] + right[i];
        }
        return res;
    }
}