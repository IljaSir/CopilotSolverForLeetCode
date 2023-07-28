class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        
        int height = wall.size();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < height; i++) {
            int width = 0;
            for (int j = 0; j < wall.get(i).size() - 1; j++) {
                width += wall.get(i).get(j);
                map.put(width, map.getOrDefault(width, 0) + 1);
            }
        }
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            max = Math.max(max, entry.getValue());
        }
        return height - max;
    }
}