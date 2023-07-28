class Solution {
    public int magnificentSets(int n, int[][] edges) {
        
        int[] group = new int[n];
        int[] groupSize = new int[n];
        int[] groupNum = new int[n];
        int[] groupNumSize = new int[n];
        for (int i = 0; i < n; i++) {
            group[i] = i;
            groupSize[i] = 1;
            groupNum[i] = i;
            groupNumSize[i] = 1;
        }
        for (int[] edge : edges) {
            int a = edge[0] - 1;
            int b = edge[1] - 1;
            int groupA = find(group, a);
            int groupB = find(group, b);
            if (groupA != groupB) {
                group[groupA] = groupB;
                groupSize[groupB] += groupSize[groupA];
            }
            int groupNumA = find(groupNum, a);
            int groupNumB = find(groupNum, b);
            if (groupNumA != groupNumB) {
                groupNum[groupNumA] = groupNumB;
                groupNumSize[groupNumB] += groupNumSize[groupNumA];
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(find(group, i));
        }
        int result = 0;
        for (int i : set) {
            result += groupSize[i];
        }
        return result;
    }
    private int find(int[] group, int i) {
        if (group[i] != i) {
            group[i] = find(group, group[i]);
        }
        return group[i];
    }
}