class Solution {
    public boolean circularArrayLoop(int[] nums) {
        
        int n = nums.length;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            int slow = i, fast = i;
            int direction = nums[i] > 0 ? 1 : -1;
            do {
                slow = next(slow, nums, direction);
                visited[slow] = true;
                fast = next(fast, nums, direction);
                if (fast == -1) {
                    break;
                }
                visited[fast] = true;
                fast = next(fast, nums, direction);
            } while (fast != -1 && slow != fast);
            if (slow != fast) {
                continue;
            }
            if (slow == next(slow, nums, direction)) {
                continue;
            }
            return true;
        }
        return false;
    }

    private int next(int i, int[] nums, int direction) {
        if (nums[i] > 0 && direction == -1) {
            return -1;
        }
        if (nums[i] < 0 && direction == 1) {
            return -1;
        }
        int n = nums.length;
        int next = (i + nums[i]) % n;
        if (next < 0) {
            next += n;
        }
        return next;
    }
}