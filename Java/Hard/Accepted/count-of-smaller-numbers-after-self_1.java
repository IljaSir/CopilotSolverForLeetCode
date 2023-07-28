class Solution {
    public List<Integer> countSmaller(int[] nums) {
        
        int n = nums.length;
        int[] res = new int[n];
        int[] index = new int[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        mergeSort(nums, index, 0, n - 1, res);
        List<Integer> ans = new ArrayList<>();
        for (int i : res) {
            ans.add(i);
        }
        return ans;
    }

    private void mergeSort(int[] nums, int[] index, int start, int end, int[] res) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(nums, index, start, mid, res);
        mergeSort(nums, index, mid + 1, end, res);
        merge(nums, index, start, mid, end, res);
    }

    private void merge(int[] nums, int[] index, int start, int mid, int end, int[] res) {
        int[] temp = new int[end - start + 1];
        int left = start;
        int right = mid + 1;
        int count = 0;
        int rightCount = 0;
        while (left <= mid || right <= end) {
            if (left > mid) {
                temp[count] = index[right];
                right++;
            } else if (right > end) {
                temp[count] = index[left];
                res[index[left]] += rightCount;
                left++;
            } else if (nums[index[left]] <= nums[index[right]]) {
                temp[count] = index[left];
                res[index[left]] += rightCount;
                left++;
            } else {
                temp[count] = index[right];
                right++;
                rightCount++;
            }
            count++;
        }
        for (int i = 0; i < temp.length; i++) {
            index[start + i] = temp[i];
        }
    }
}