class Solution {
    public List<Integer> countSmaller(int[] nums) {
        
        Integer[] res = new Integer[nums.length];
        int[] index = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }
        mergeSort(nums, index, 0, nums.length - 1, res);
        return Arrays.asList(res);
    }
    
    private void mergeSort(int[] nums, int[] index, int start, int end, Integer[] res) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(nums, index, start, mid, res);
        mergeSort(nums, index, mid + 1, end, res);
        merge(nums, index, start, end, res);
    }
    
    private void merge(int[] nums, int[] index, int start, int end, Integer[] res) {
        int mid = start + (end - start) / 2;
        int i = start;
        int j = mid + 1;
        int k = 0;
        int[] newIndex = new int[end - start + 1];
        while (i <= mid && j <= end) {
            if (nums[index[i]] > nums[index[j]]) {
                newIndex[k++] = index[j++];
                res[index[i]] += mid - i + 1;
            } else {
                newIndex[k++] = index[i++];
            }
        }
        while (i <= mid) {
            newIndex[k++] = index[i++];
        }
        while (j <= end) {
            newIndex[k++] = index[j++];
        }
        for (int l = 0; l < newIndex.length; l++) {
            index[start + l] = newIndex[l];
        }
    }
}