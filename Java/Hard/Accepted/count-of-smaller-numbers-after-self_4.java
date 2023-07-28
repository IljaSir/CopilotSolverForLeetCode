class Solution {
    public List<Integer> countSmaller(int[] nums) {
        
        List<Integer> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }
        int n = nums.length;
        int[] index = new int[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        int[] count = new int[n];
        mergeSort(nums, index, count, 0, n - 1);
        for (int i = 0; i < n; i++) {
            ans.add(count[i]);
        }
        return ans;
    }
    private void mergeSort(int[] nums, int[] index, int[] count, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(nums, index, count, start, mid);
        mergeSort(nums, index, count, mid + 1, end);
        merge(nums, index, count, start, end);
    }
    private void merge(int[] nums, int[] index, int[] count, int start, int end) {
        int mid = start + (end - start) / 2;
        int[] left = Arrays.copyOfRange(index, start, mid + 1);
        int[] right = Arrays.copyOfRange(index, mid + 1, end + 1);
        int i = 0, j = 0;
        int rightCount = 0;
        while (i < left.length && j < right.length) {
            if (nums[left[i]] > nums[right[j]]) {
                rightCount++;
                index[start++] = right[j++];
            } else {
                count[left[i]] += rightCount;
                index[start++] = left[i++];
            }
        }
        while (i < left.length) {
            count[left[i]] += rightCount;
            index[start++] = left[i++];
        }
        while (j < right.length) {
            index[start++] = right[j++];
        }
    }
}