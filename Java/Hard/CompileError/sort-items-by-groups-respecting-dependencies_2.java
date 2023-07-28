class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        
        int[] groupIds = new int[n];
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = m;
                groupIds[m] = m;
                m++;
            }
        }
        for (int i = 0; i < n; i++) {
            groupIds[i] = group[i];
        }
        Map<Integer, List<Integer>> groupGraph = new HashMap<>();
        Map<Integer, List<Integer>> itemGraph = new HashMap<>();
        int[] groupInDegree = new int[m];
        int[] itemInDegree = new int[n];
        for (int i = 0; i < n; i++) {
            if (itemGraph.get(i) == null) {
                itemGraph.put(i, new ArrayList<>());
            }
            for (int j : beforeItems.get(i)) {
                itemGraph.get(j).add(i);
                itemInDegree[i]++;
            }
        }
        for (int i = 0; i < n; i++) {
            int curGroupId = group[i];
            List<Integer> curGroupItems = groupGraph.getOrDefault(curGroupId, new ArrayList<>());
            curGroupItems.add(i);
            groupGraph.put(curGroupId, curGroupItems);
            for (int j : beforeItems.get(i)) {
                int preGroupId = group[j];
                if (preGroupId != curGroupId) {
                    List<Integer> preGroupItems = groupGraph.getOrDefault(preGroupId, new ArrayList<>());
                    preGroupItems.add(curGroupId);
                    groupGraph.put(preGroupId, preGroupItems);
                    groupInDegree[curGroupId]++;
                }
            }
        }
        List<Integer> groupSorted = topSort(groupGraph, groupInDegree);
        if (groupSorted.size() == 0) {
            return new int[0];
        }
        int[] result = new int[n];
        int index = 0;
        for (int groupId : groupSorted) {
            List<Integer> groupItems = groupGraph.get(groupId);
            if (groupItems.size() == 1) {
                result[index++] = groupItems.get(0);
            } else {
                Map<Integer, List<Integer>> subItemGraph = new HashMap<>();
                int[] subItemInDegree = new int[groupItems.size()];
                for (int i = 0; i < groupItems.size(); i++) {
                    int curItem
    }
}