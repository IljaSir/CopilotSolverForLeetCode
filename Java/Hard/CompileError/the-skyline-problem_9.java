class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        
        // 1. divide and conquer
        // 2. heap
        // 3. sweep line
        // 4. segment tree
        return divideAndConquer(buildings, 0, buildings.length - 1);
retur

    public List<List<Integer>> divideAndConquer(int[][] buildings, int start, int end) {
        if (start > end) {
            return new ArrayList<>();
        }
        if (start == end) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(Arrays.asList(buildings[start][0], buildings[start][2]));
            result.add(Arrays.asList(buildings[start][1], 0));
            return result;n result;

        int mid = start + (end - start) / 2;
    }
}