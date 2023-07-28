class Solution {
    public int numSquarefulPerms(int[] nums) {
        
        int n = nums.length;
        int[] count = new int[1];
        Arrays.sort(nums);
        boolean[] visited = new boolean[n];
        backtrack(nums, visited, new ArrayList<>(), count);
        return count[0];
    }

    private void backtrack(int[] nums, boolean[] visited, List<Integer> list, int[] count) {
        if (list.size() == nums.length) {
            count[0]++;
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            if (list.size() > 0 && !isPerfectSquare(list.get(list.size() - 1) + nums[i])) {
                continue;
            }
            visited[i] = true;
            list.add(nums[i]);
            backtrack(nums, visited, list, count);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }

    private boolean isPerfectSquare(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }
}