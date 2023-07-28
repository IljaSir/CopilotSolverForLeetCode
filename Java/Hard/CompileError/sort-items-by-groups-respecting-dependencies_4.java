class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        
        int[] res = new int[n];
        int[] groupSize = new int[m];
        int[] groupInDegree = new int[m];
        int[] itemSize = new int[n];
        int[] itemInDegree = new int[n];
        int[] groupMap = new int[n];
        List<Integer>[] groupAdj = new List[m];
        List<Integer>[] itemAdj = new List[n];
        for (int i = 0; i < m; i++) {
            groupAdj[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            itemAdj[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = m++;
            }
            groupSize[group[i]]++;
            groupMap[i] = group[i];
        }
        for (int i = 0; i < n; i++) {
            for (int j : beforeItems.get(i)) {
                if (groupMap[j] == groupMap[i]) {
                    itemAdj[j].add(i);
                    itemInDegree[i]++;
                } else {
                    groupAdj[groupMap[j]].add(groupMap[i]);
                    groupInDegree[groupMap[i]]++;
                }
            }
        }
        List<Integer> groupOrder = topSort(groupAdj, groupInDegree, m);
        if (groupOrder.size() == 0) {
            return new int[0];
        }
        int[] groupIndex = new int[m];
        for (int i = 0; i < m; i++) {
            groupIndex[groupOrder.get(i)] = i;
        }
        for (int i = 0; i < n; i++) {
            group[i] = groupIndex[group[i]];
        }
        List<Integer>[] groupItems = new List[m];
        for (int i = 0; i < m; i++) {
            groupItems[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            groupItems[group[i]].add(i);
        }
        for (int i = 0; i < m; i++) {
            List<Integer> itemOrder = topSort(itemAdj, itemInDegree, groupItems[i].size());
            if (itemOrder.size() == 0) {
    }
}