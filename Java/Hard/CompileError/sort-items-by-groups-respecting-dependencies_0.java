class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        
        List<List<Integer>> groupGraph = new ArrayList<>();
        for (int i = 0; i < m + n; i++) {
            groupGraph.add(new ArrayList<>());
        }
        List<List<Integer>> itemGraph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            itemGraph.add(new ArrayList<>());
        }
        int[] groupInDegree = new int[m + n];
        int[] itemInDegree = new int[n];
        List<Integer> groupIds = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = m + i;
            }
            if (!groupIds.contains(group[i])) {
                groupIds.add(group[i]);
            }
            for (int item : beforeItems.get(i)) {
                if (group[item] != group[i]) {
                    groupGraph.get(group[item]).add(group[i]);
                    groupInDegree[group[i]]++;
                }
                itemGraph.get(item).add(i);
                itemInDegree[i]++;
            }
        }
        List<Integer> groupOrder = topSort(groupGraph, groupInDegree, groupIds);
        if (groupOrder.size() == 0) {
            return new int[0];
        }
        int[] ans = new int[n];
        int index = 0;
        for (int curGroupId : groupOrder) {
            int curGroupSize = 0;
            List<Integer> itemId = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (group[i] == curGroupId) {
                    curGroupSize++;
                    itemId.add(i);
                }
            }
            List<Integer> itemOrder = topSort(itemGraph, itemInDegree, itemId);
            if (itemOrder.size() == 0) {
                return new int[0];
            }
            for (int curItemId : itemOrder) {
                ans[index++] = curItemId;
            }
        }
        return ans;
    }
    public List<Integer> topSort(List<List<Integer>> graph, int[] inDegree, List<Integer> ids) {
        Queue<Integer> queue = new LinkedList<>();
        for (int id : ids) {
            if (inDegree[id] == 0) {
                queue.offer(id);
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!
    }
}