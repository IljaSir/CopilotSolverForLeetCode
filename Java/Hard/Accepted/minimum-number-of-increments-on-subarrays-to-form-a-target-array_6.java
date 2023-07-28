class Solution {
    public int minNumberOperations(int[] target) {
        
        int sum = 0;
        for (int i = 0; i < target.length; i++) {
            if (i == 0) {
                sum += target[i];
            } else {
                sum += Math.max(target[i] - target[i - 1], 0);
            }
        }
        return sum;
    }
}