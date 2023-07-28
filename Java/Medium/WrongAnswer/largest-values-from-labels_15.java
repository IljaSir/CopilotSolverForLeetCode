class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        
        int[][] items = new int[values.length][2];
        for(int i = 0; i < values.length; i++) {
            items[i][0] = values[i];
            items[i][1] = labels[i];
        }
        Arrays.sort(items, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return b[0] - a[0];
            }
        });
        Map<Integer, Integer> count = new HashMap<>();
        int ans = 0;
        for(int i = 0; i < numWanted; i++) {
            if(count.getOrDefault(items[i][1], 0) < useLimit) {
                ans += items[i][0];
                count.put(items[i][1], count.getOrDefault(items[i][1], 0) + 1);
            }
        }
        return ans;
    }
}