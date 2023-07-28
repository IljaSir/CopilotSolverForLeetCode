class Solution {
    public int findMaxK(int[] nums) {
        
        int max = Integer.MIN_VALUE;
        for(int n : nums) {
            if(Math.abs(n) > max) {
                max = Math.abs(n);
            }
        }
        return max;
    }
    public int largestInteger(int[] nums) {
        int max = findMaxK(nums);
        boolean[] visited = new boolean[max + 1];
        for(int n : nums) {
            if(n > 0) {
                visited[n] = true;
            }
        }
        for(int i = max; i >= 1; i--) {
            if(visited[i] && visited[-i]) {
                return i;
            }
        }
        return -1;
    }
}
    }
}