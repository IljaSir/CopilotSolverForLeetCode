class Solution {
    public int[] minOperations(String boxes) {
        
        int[] res = new int[boxes.length()];
        int left = 0;
        int right = 0;
        int leftCount = 0;
        int rightCount = 0;
        for (int i = 0; i < boxes.length(); i++) {
            if (boxes.charAt(i) == '1') {
                rightCount++;
                right += i;
            }
        }
        for (int i = 0; i < boxes.length(); i++) {
            res[i] = left + right;
            if (boxes.charAt(i) == '1') {
                leftCount++;
                rightCount--;
                left += leftCount;
                right -= rightCount;
            }
        }
        return res;
    }
}