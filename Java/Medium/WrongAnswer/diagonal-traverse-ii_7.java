class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        
        int n = nums.size();
        int m = 0;
        for (var l : nums) {
            m = Math.max(m, l.size());
        }
        var q = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                q.offer(new int[] {i + j, i});
            }
        }
        int[] ans = new int[q.size()];
        int i = 0;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            ans[i++] = nums.get(p[1]).get(p[0] - p[1]);
        }
        return ans;
    }
}