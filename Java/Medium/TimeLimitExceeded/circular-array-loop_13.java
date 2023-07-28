class Solution {
    public boolean circularArrayLoop(int[] nums) {
        
        if (nums.length <= 1) {
            return false;
        }
        int n = nums.length;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            int start = i;
            int cur = i;
            boolean isForward = nums[i] > 0;
            while (true) {
                int next = (cur + nums[cur]) % n;
                if (next < 0) {
                    next += n;
                }
                if (next == cur || (nums[next] > 0) != isForward) {
                    break;
                }
                if (next == start) {
                    return true;
                }
                visited[cur] = true;
                cur = next;
            }
        }
        return false;
    }
}