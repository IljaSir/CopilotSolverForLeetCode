class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < matches.length; i++) {
            map.put(matches[i][0], map.getOrDefault(matches[i][0], 0) + 1);
            map.put(matches[i][1], map.getOrDefault(matches[i][1], 0));
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        for (int key : map.keySet()) {
            if (map.get(key) == 0) {
                ans.get(0).add(key);
            } else if (map.get(key) == 1) {
                ans.get(1).add(key);
            }
        }
        return ans;
    }
}