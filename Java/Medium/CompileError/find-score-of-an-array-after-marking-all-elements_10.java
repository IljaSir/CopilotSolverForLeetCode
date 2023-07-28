class Solution {
    public long findScore(int[] nums) {
        
        int n = nums.length;
        long score = 0;
        int[] marked = ne
        }
        for (int i = 0; i < n; i++) {
            if (left[i] != -1 && right[i] != -1) {
                score += arr[i];
                arr[left[i]] = Math.max(arr[left[i]], arr[i]);
                arr[right[i]] = Math.max(arr[right[i]], arr[i]);
            }
        }
        return score;
    }
}