class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i];
        }
        for (int i = 0; i < operations.length; i++) {
            int[] operation = operations[i];
            int index = getIndex(result, operation[0]);
            if (index != -1) {
                result[index] = operation[1];
            }
        }
        return result;
    }
    
    private int getIndex(int[] nums, int n) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == n) {
                return i;
            }
        }
        return -1;
    }
}
    }
}