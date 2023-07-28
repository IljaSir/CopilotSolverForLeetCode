class Solution {
    public List<Integer> countSmaller(int[] nums) {
        
        List<Integer> result = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        int[] count = new int[nums.length];
        int[] index = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }
        mergeSort(nums, count, index, 0, nums.length - 1);
        for (int i = 0; i < count.length; i++) {
            result.add(count[i]);
        }
        return result;
    }
    private void mergeSort(int[] nums, int[] count, int[] index, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(nums, count, index, start, mid);
        mergeSort(nums, count, index, mid + 1, end);
        merge(nums, count, index, start, end);
    }
    private void merge(int[] nums, int[] count, int[] index, int start, int end) {
        int mid = start + (end - start) / 2;
        int left = start;
        int right = mid + 1;
        int[] temp = new int[end - start + 1];
        int indexTemp = 0;
        while (left <= mid && right <= end) {
            if (nums[index[left]] <= nums[index[right]]) {
                temp[indexTemp] = index[left];
                count[index[left]] += right - mid - 1;
                indexTemp++;
                left++;
            } else {
                temp[indexTemp] = index[right];
                indexTemp++;
                right++;
            }
        }
        while (left <= mid) {
            temp[indexTemp] = index[left];
            count[index[left]] += right - mid - 1;
            indexTemp++;
            left++;
        }
        while (right <= end) {
            temp[indexTemp] = index[right];
            indexTemp++;
            right++;
        }
        for (int i = 0; i < temp.length; i++) {
            index[start + i] = temp[i];
        }
    }
}