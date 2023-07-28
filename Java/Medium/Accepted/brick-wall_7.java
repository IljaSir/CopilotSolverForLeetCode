class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        
        int n = wall.size();
        int res = n;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (List<Integer> row : wall) {
            int sum = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                sum += row.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
                res = Math.min(res, n - map.get(sum));
            }
        }
        return res;
    }
}