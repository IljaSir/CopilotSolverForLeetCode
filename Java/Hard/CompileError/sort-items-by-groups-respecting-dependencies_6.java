class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        
        int[] ans = new int[n];
        int[] groupSize = new int[m];
        int[] groupInDegree = new int[m];
        int[] groupOutDegree = new int[m];
        int[] itemSize = new int[n];
        int[] itemInDegree = new int[n];
        int[] itemOutDegree = new int[n];
        List<Integer>[] groupNext = new List[m];
        List<Integer>[] itemNext = new List[n];
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = m++;
            }
            groupSize[group[i]]++;
            itemSize[i]++;
        }
        for (int i = 0; i < n; i++) {
            if (groupNext[group[i]] == null) {
                groupNext[group[i]] = new ArrayList<>();
            }
            if (itemNext[i] == null) {
                itemNext[i] = new ArrayList<>();
            }
            for (int j : beforeItems.get(i)) {
                if (group[j] != group[i]) {
                    groupOutDegree[group[j]]++;
                    groupInDegree[group[i]]++;
                    groupNext[group[j]].add(group[i]);
                } else {
                    itemOutDegree[j]++;
                    itemInDegree[i]++;
                    itemNext[j].add(i);
                }
            }
        }
        int[][] groupOrder = new int[m][];
        for (int i = 0; i < m; i++) {
            if (groupInDegree[i] == 0) {
                groupOrder[i] = topologicalSort(groupNext[i], groupOutDegree);
            }
        }
        int[][] itemOrder = new int[n][];
        for (int i = 0; i < n; i++) {
            if (itemInDegree[i] == 0) {
                itemOrder[i] = topologicalSort(itemNext[i], itemOutDegree);
            }
        }
        int index = 0;
        for (int i = 0; i < m; i++) {
            if (groupOrder[i] != null) {
                for (int j : groupOrder[i]) {
                    if (itemOrder[j] != null) {
                        for (int k : itemOrder[j]) {
                            ans[index++] = k;
                        }
                    }
                }
            }
        }
        return index == n ? ans
    }
}