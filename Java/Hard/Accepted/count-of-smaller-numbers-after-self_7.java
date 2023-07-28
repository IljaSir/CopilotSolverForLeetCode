class Solution {
    public List<Integer> countSmaller(int[] nums) {
        
        List<Integer> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        int[] count = new int[nums.length];
        int[] index = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }
        mergeSort(nums, index, count, 0, nums.length - 1);
        for (int i = 0; i < count.length; i++) {
            result.add(count[i]);
        }
        return result;
    }
    private void mergeSort(int[] nums, int[] index, int[] count, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(nums, index, count, start, mid);
        mergeSort(nums, index, count, mid + 1, end);
        merge(nums, index, count, start, mid, end);
    }
    private void merge(int[] nums, int[] index, int[] count, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int left = start;
        int right = mid + 1;
        int indexTemp = 0;
        while (left <= mid && right <= end) {
            if (nums[index[left]] <= nums[index[right]]) {
                count[index[left]] += right - mid - 1;
                temp[indexTemp++] = index[left++];
            } else {
                temp[indexTemp++] = index[right++];
            }
        }
        while (left <= mid) {
            count[index[left]] += right - mid - 1;
            temp[indexTemp++] = index[left++];
        }
        while (right <= end) {
            temp[indexTemp++] = index[right++];
        }
        for (int i = 0; i < temp.length; i++) {
            index[start + i] = temp[i];
        }
    }
}