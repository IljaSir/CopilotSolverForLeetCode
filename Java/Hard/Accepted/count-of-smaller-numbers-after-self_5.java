class Solution {
    public List<Integer> countSmaller(int[] nums) {
        
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        int[] counts = new int[n];
        int[] indexes = new int[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }
        mergeSort(nums, counts, indexes, 0, n - 1);
        for (int count : counts) {
            result.add(count);
        }
        return result;
    }

    public void mergeSort(int[] nums, int[] counts, int[] indexes, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(nums, counts, indexes, start, mid);
        mergeSort(nums, counts, indexes, mid + 1, end);
        merge(nums, counts, indexes, start, end);
    }

    public void merge(int[] nums, int[] counts, int[] indexes, int start, int end) {
        int mid = start + (end - start) / 2;
        int i = start;
        int j = mid + 1;
        int rightCount = 0;
        int[] newIndexes = new int[end - start + 1];
        int index = 0;
        while (i <= mid || j <= end) {
            if (i > mid) {
                newIndexes[index] = indexes[j];
                j++;
            } else if (j > end) {
                newIndexes[index] = indexes[i];
                counts[indexes[i]] += rightCount;
                i++;
            } else if (nums[indexes[i]] <= nums[indexes[j]]) {
                newIndexes[index] = indexes[i];
                counts[indexes[i]] += rightCount;
                i++;
            } else {
                newIndexes[index] = indexes[j];
                rightCount++;
                j++;
            }
            index++;
        }
        for (int k = 0; k < newIndexes.length; k++) {
            indexes[start + k] = newIndexes[k];
        }
    }
}