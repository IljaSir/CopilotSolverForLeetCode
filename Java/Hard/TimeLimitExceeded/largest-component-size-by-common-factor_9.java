class Solution {
    public int largestComponentSize(int[] nums) {
        
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int[] size = new int[n];
        int max = 1;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int root1 = i;
            for (int j = 2; j <= Math.sqrt(num); j++) {
                if (num % j == 0) {
                    int root2 = map.getOrDefault(j, j);
                    while (root2 != size[root2]) {
                        root2 = size[root2];
                    }
                    size[root1] = root2;
                    root1 = root2;
                    
                    int root3 = map.getOrDefault(num / j, num / j);
                    while (root3 != size[root3]) {
                        root3 = size[root3];
                    }
                    size[root1] = root3;
                    root1 = root3;
                }
            }
            map.put(num, root1);
            size[root1]++;
            max = Math.max(max, size[root1]);
        }
        return max;
    }
}