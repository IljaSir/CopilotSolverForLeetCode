class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        
        int[] res = new int[n];
        int[] groupSize = new int[m];
        int[] groupIndegree = new int[m];
        int[] itemIndegree = new int[n];
        int[] groupItemIndegree = new int[n];
        int[] groupRes = new int[n];
        Map<Integer, List<Integer>> groupMap = new HashMap<>();
        Map<Integer, List<Integer>> groupItemMap = new HashMap<>();
        List<List<Integer>> groupList = new ArrayList<>();
        List<List<Integer>> groupItemList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = m++;
            }
            groupSize[group[i]]++;
            groupMap.putIfAbsent(group[i], new ArrayList<>());
            groupMap.get(group[i]).add(i);
        }
        for (int i = 0; i < n; i++) {
            for (int j : beforeItems.get(i)) {
                if (group[j] != group[i]) {
                    groupIndegree[group[i]]++;
                    groupItemIndegree[i]++;
                } else {
                    itemIndegree[i]++;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            if (groupSize[i] > 0) {
                groupRes = topologicalSort(groupSize[i], groupIndegree[i], groupItemIndegree, groupMap.get(i), beforeItems, groupItemMap);
                if (groupRes.length == 0) {
                    return new int[0];
                }
                groupList.add(Arrays.stream(groupRes).boxed().collect(Collectors.toList()));
            }
        }
        for (int i = 0; i < groupList.size(); i++) {
            for (int j = 0; j < groupList.get(i).size(); j++) {
                res[groupList.get(i).get(j)] = i;
            }
        }
        for (int i = 0; i < n; i++) {
            groupItemList.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            groupItemList.get(res[i]).add(i);
        }
        for (int i = 0; i < groupItemList.size(); i++) {
            if (groupItemList.get(i).size() > 0) {
                groupRes = topological
    }
}