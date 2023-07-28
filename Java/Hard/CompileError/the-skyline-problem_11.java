class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        
        // 1. divide and conquer
        // 2. heap
        // 3. sweep line
        // 4. segment tree
        return divideAndConquer(buildings, 0, buildings.length - 1);
    }

    public List<List<Integer>> divideAndConquer(int[][] buildings, int start, int end) {
        if (start > end) {
            return new ArrayList<>();
        }
        if (start == end) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(Arrays.asList(buildings[start][0], buildings[start][2]));
            result.add(Arrays.asList(buildings[start][1], 0));
            return result;
        }
        int mid = start + (end - start) / 2;
        List<List<Integer>> left = divideAndConquer(buildings, start, mid);
        List<List<Integer>> right = divideAndConquer(buildings, mid + 1, end);
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
    }
}