class Solution {
    public void wiggleSort(int[] nums) {
        
        // O(nlogn)
        // Arrays.sort(nums);
        // int[] ans = new int[nums.length];
        // int i = 0, j = nums.length - 1;
        // int k = 0;
        // while (i < j) {
        //     ans[k++] = nums[i++];
        //     ans[k++] = nums[j--];
        // }
        // if (i == j) ans[k] = nums[i];
        // for (int l = 0; l < nums.length; l++) {
        //     nums[l] = ans[l];
        // }

        // O(n)
        int n = nums.length;
        int median = findKthLargest(nums, (n + 1) / 2);
        int left = 0, i = 0, right = n - 1;
        while (i <= right) {
            if (nums[newIndex(i, n)] > median) {
                swap(nums, newIndex(left++, n), newIndex(i++, n));
            } else if (nums[newIndex(i, n)] < median) {
                swap(nums, newIndex(right--, n), newIndex(i, n));
            } else {
                i++;
            }
        }
    }

    public int newIndex(int index, int n) {
        return (1 + 2 * index) % (n | 1);
    }

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return quickSelect(nums, 0, n - 1, n - k);
    }

    public int quickSelect(int[] nums, int lo, int hi, int k) {
        int i = lo, j = hi, pivot = nums[hi];
        while (i < j) {
            if (nums[i++] > pivot) swap(nums, --i, --j);
        }
        swap(nums, i, hi);
        int m = i - lo + 1;
        if (m == k) return nums[i];
        else if (m > k) return quickSelect(nums, lo, i - 1, k);
        else return quickSelect(nums, i + 1, hi, k - m);
    }
}