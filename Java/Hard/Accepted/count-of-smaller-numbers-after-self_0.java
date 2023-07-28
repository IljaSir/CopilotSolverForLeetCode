class Solution {
    public List<Integer> countSmaller(int[] nums) {
        
        int n = nums.length;
        int[] count = new int[n];
        int[] index = new int[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        mergeSort(nums, count, index, 0, n - 1);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(count[i]);
        }
        return res;
    }

    private void mergeSort(int[] nums, int[] count, int[] index, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(nums, count, index, start, mid);
        mergeSort(nums, count, index, mid + 1, end);
        merge(nums, count, index, start, end);
    }

    private void merge(int[] nums, int[] count, int[] index, int start, int end) {
        int mid = (start + end) / 2;
        int left = start;
        int right = mid + 1;
        int[] tmp = new int[end - start + 1];
        int indexTmp = 0;
        while (left <= mid && right <= end) {
            if (nums[index[left]] <= nums[index[right]]) {
                count[index[left]] += right - mid - 1;
                tmp[indexTmp++] = index[left++];
            } else {
                tmp[indexTmp++] = index[right++];
            }
        }

        while (left <= mid) {
            count[index[left]] += right - mid - 1;
            tmp[indexTmp++] = index[left++];
        }

        while (right <= end) {
            tmp[indexTmp++] = index[right++];
        }

        for (int i = start; i <= end; i++) {
            index[i] = tmp[i - start];
        }
    }
}