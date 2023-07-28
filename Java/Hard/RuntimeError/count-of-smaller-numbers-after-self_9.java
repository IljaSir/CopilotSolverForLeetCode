class Solution {
    public List<Integer> countSmaller(int[] nums) {
        
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        int[] sorted = new int[n];
        for (int i = n-1; i >= 0; i--) {
            int index = findIndex(sorted, 0, n-1, nums[i]);
            result.add(0, index);
            for (int j = n-1; j > index; j--) {
                sorted[j] = sorted[j-1];
            }
            sorted[index] = nums[i];
        }
        return result;
    }
    
    private int findIndex(int[] sorted, int start, int end, int target) {
        if (start > end) return start;
        int mid = start + (end - start) / 2;
        if (sorted[mid] < target) {
            return findIndex(sorted, mid + 1, end, target);
        } else {
            return findIndex(sorted, start, mid - 1, target);
        }
    }
}