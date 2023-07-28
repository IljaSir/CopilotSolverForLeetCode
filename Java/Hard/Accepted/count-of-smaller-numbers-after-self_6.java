class Solution {
    public List<Integer> countSmaller(int[] nums) {
        
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        int n = nums.length;
        int[] smaller = new int[n];
        int[] index = new int[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        mergeSort(nums, smaller, index, 0, n - 1);
        for (int i = 0; i < n; i++) {
            result.add(smaller[i]);
        }
        return result;
    }

    private void mergeSort(int[] nums, int[] smaller, int[] index, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(nums, smaller, index, left, mid);
        mergeSort(nums, smaller, index, mid + 1, right);
        merge(nums, smaller, index, left, mid, right);
    }

    private void merge(int[] nums, int[] smaller, int[] index, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        int count = 0;
        while (i <= mid && j <= right) {
            if (nums[index[i]] <= nums[index[j]]) {
                smaller[index[i]] += count;
                temp[k++] = index[i++];
            } else {
                count++;
                temp[k++] = index[j++];
            }
        }
        while (i <= mid) {
            smaller[index[i]] += count;
            temp[k++] = index[i++];
        }
        while (j <= right) {
            temp[k++] = index[j++];
        }
        for (int p = 0; p < temp.length; p++) {
            index[left + p] = temp[p];
        }
    }
}