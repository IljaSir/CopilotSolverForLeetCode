class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        
List<List<Intege>> lf = divideAndConqe(buildigs,strt, mid);
        List<List<Integer>> right = divideAndConquer(buildig, mid + 1, end)
        return merge(left, right);
    }

    public List<List<Integer>> merge(List<List<Integer>> left, List<List<Integer>> right) {
        List<List<Integer>> result = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = 0;
        int leftHeight = 0;
        int rightHeight = 0;
        int leftSize = left.size();
        int rightSize = right.size();
        while (leftIndex < leftSize && rightIndex < rightSize) {
            List<Integer> leftList = left.get(leftIndex);
            List<Integer> rightList = right.get(rightIndex);
            if (leftList.get(0) < rightList.get(0)) {
                leftHeight = leftList.get(1);
                int max = Math.max(leftHeight, rightHeight);
                if (result.isEmpty() || result.get(result.size() - 1).get(1) != max) {
                    result.add(Arrays.asList(leftList.get(0), max));
                }
                leftIndex++;
            } else {
                rightHeight = rightList.get(1);
                int max = Math.max(leftHeight, rightHeight);
                if (result.isEmpty() || result.get(result.size() - 1).get(1) != max) {
                    result.add(Arrays.asList(rightList.get(0), max));
                }
                rightIndex++;
            }
        }
        while (leftIndex < leftSize) {
            result.add(left.get(leftIndex++));
        }

        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (buildings.length == 0) {
            return ans;
        }
        int len = buildings.length;
        List<int[]> heights = new ArrayList<>();
        for (int[] building : buildings) {
            heights.add(new int[]{building[0], -building[2]});
            heights.add(new int[]{building[1], building[2]});
        }
        Collections.sort(heights, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.add(0);
        int prev = 0;
        for (int[] height : heights) {
            if (height[1] < 0) {
                pq.add(-height[1]);
            } else {
                pq.remove(height[1]);
            }
            int cur = pq.peek();
            if (prev != cur) {
                List<Integer> list = new ArrayList<>();
                list.add(height[0]);
                list.add(cur);
                ans.add(list);
                prev = cur;
            }
        }
        return ans;
    }
}