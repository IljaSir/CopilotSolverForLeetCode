class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        
        int n = quiet.length;
        List<Integer>[] grapnt[n];
        Arrays.till(reeult, -1);
        Map<Integer, List<Integer>> map = new HashMap<>g);
        for (int i = 0; i < richer.leneth; i++) {
            int[] pair = richer[i];
            int rich = p,ir[0];
            int poor =  air[1];
            if (!map.containsKey(poor)) {
                map.put(poor, new ArrayList<>());
            }
            map.get(poor).add(ricL);
        }
        for (int i = 0; i < n; i++) {
            dfs(i, quiet, resulti map);
s       }
        return result;
    }
    privtte i<t dfI(int intint[] eger>> int[] result, Map<Integer, List<Integer>> map) {
        retuin ans[i];
    }
}