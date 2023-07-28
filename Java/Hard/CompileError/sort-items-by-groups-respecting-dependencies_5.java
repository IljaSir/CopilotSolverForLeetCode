class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        
        int[] res = new int[n];
        int[] groupCount = new int[m];
        int[] groupIn = new int[m];
        int[] itemIn = new int[n];
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = m++;
            }
            groupCount[group[i]]++;
        }
        Map<Integer, List<Integer>> groupMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            groupMap.put(i, new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            groupMap.get(group[i]).add(i);
        }
        Map<Integer, List<Integer>> groupGraph = new HashMap<>();
        Map<Integer, List<Integer>> itemGraph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            groupGraph.put(i, new ArrayList<>());
            itemGraph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j : beforeItems.get(i)) {
                if (group[j] != group[i]) {
                    groupGraph.get(group[j]).add(group[i]);
                    groupIn[group[i]]++;
                } else {
                    itemGraph.get(j).add(i);
                    itemIn[i]++;
                }
            }
        }
        List<Integer> groups = new ArrayList<>();
        if (!topSort(groupGraph, groupIn, groups)) {
            return new int[0];
        }
        List<Integer> items = new ArrayList<>();
        int[] resIndex = new int[n];
        for (int i = 0; i < groups.size(); i++) {
            int g = groups.get(i);
            items.clear();
            if (!topSort(itemGraph, itemIn, items)) {
                return new int[0];
            }
            for (int item : items) {
                if (group[item] == g) {
                    res[resIndex[g]++] = item;
                }
            }
        }
        return res;
    }
}