class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        
        Map<Integer, Integer> map = new HashMap<>();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            list.add(new int[]{values[i], labels[i]});
        }
        list.sort((a, b) -> b[0] - a[0]);
        int res = 0;
        for (int i = 0; i < list.size() && numWanted > 0; i++) {
            int[] cur = list.get(i);
            int label = cur[1];
            if (map.containsKey(label) && map.get(label) >= useLimit) {
                continue;
            }
            map.put(label, map.getOrDefault(label, 0) + 1);
            res += cur[0];
            numWanted--;
        }
        return res;
    }
}