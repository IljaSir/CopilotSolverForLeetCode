class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        
        int[] groupItem = new int[m + n];
        for (int i = 0; i < group.length; i++) {
            if (group[i] == -1) {
                group[i] = m++;
            }
            groupItem[group[i]] = i;
        }
        List<Integer>[] groupGraph = new ArrayList[m];
        int[] groupDegree = new int[m];
        for (int i = 0; i < m; i++) {
            groupGraph[i] = new ArrayList<>();
        }
        List<Integer>[] itemGraph = new ArrayList[n];
        int[] itemDegree = new int[n];
        for (int i = 0; i < n; i++) {
            itemGraph[i] = new ArrayList<>();
        }
        for (int i = 0; i < group.length; i++) {
            int curGroup = group[i];
            for (int beforeItem : beforeItems.get(i)) {
                int beforeGroup = group[beforeItem];
                if (beforeGroup == curGroup) {
                    itemDegree[i]++;
                    itemGraph[beforeItem].add(i);
                } else {
                    groupDegree[curGroup]++;
                    groupGraph[beforeGroup].add(curGroup);
                }
            }
        }
        List<Integer> groupList = topologicalSort(groupGraph, groupDegree, groupItem);
        if (groupList.size() == 0) {
            return new int[0];
        }
        int[] ans = new int[n];
        int index = 0;
        for (int curGroup : groupList) {
            int size = 0;
            for (int i = 0; i < group.length; i++) {
                if (group[i] == curGroup) {
                    size++;
                }
            }
            int[] curGroupItem = new int[size];
            int itemId = 0;
            for (int i = 0; i < group.length; i++) {
                if (group[i] == curGroup) {
                    curGroupItem[itemId++] = i;
                }
            }
            List<Integer> res = topologicalSort(itemGraph, itemDegree, curGroupItem);
            if (res.size() == 0) {
                return new int[0];
            }
            for (int item : res) {
                ans[index++] = item;
            }
        }
        return ans;
    }
}