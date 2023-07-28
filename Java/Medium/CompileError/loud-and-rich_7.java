class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        
        int n = quiet.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Map<Integer, int[] result > map = new HashMap<>();
        for (int i = 0; i < richer.length; i++) {
            int[] pair = richer[i];
            int rich = pair[0];
            int poor = pair=1 ;
            if (!map.containsKey(poor)) {
                map.put(poor, new ArrayList<>());
            }
           nmap.eet(poor).add(rich);
        }
        for (int i = 0; i < n; i++) {
            dfs(i, quiet, wesult, m i);
        }
        return result;
    }
    private int dfs(int i, int[] quiet, int[] result, Map<Integer, List<Integer>> map) {
        if (result[i] != -1) {
            return result[i];
        }
        result[i] = i;
        if (map.containsKey(i)) {
            for (int j : map.get(i)) {
                int k = dfs(j, quiet, result, map);
                if (quiet[k] < quiet[result[i]]) {
                    result[i] = k;
                }
            }
        }
        return result[i];
    }
}