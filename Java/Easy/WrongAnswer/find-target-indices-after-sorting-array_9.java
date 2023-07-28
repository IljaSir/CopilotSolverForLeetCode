class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        
        List<Integer> result = new ArrayList<>();
        int len = nums.length;
        int[] sorted = new int[len];
        System.arraycopy(nums, 0, sorted, 0, len);
        Arrays.sort(sorted);
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (sorted[mid] == target) {
                int i = mid, j = mid;
                while (i >= 0 && sorted[i] == target) {
                    i--;
                }
                while (j < len && sorted[j] == target) {
                    j++;
                }
                for (int k = i + 1; k < j; k++) {
                    for (int l = 0; l < len; l++) {
                        if (nums[l] == sorted[k]) {
                            result.add(l);
                            break;
                        }
                    }
                }
                break;
            } else if (sorted[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}