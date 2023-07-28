class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        
        List<Integer>[] groupGraph = new List[m + n];
        List<Integer>[] itemGraph = new List[n];
        for (int i = 0; i < groupGraph.length; i++) {
            groupGraph[i] = new ArrayList<>();
        }
        for (int i = 0; i < itemGraph.length; i++) {
            itemGraph[i] = new ArrayList<>();
        }
        int[] groupIndegree = new int[m + n];
        int[] itemIndegree = new int[n];
        int[] groupSize = new int[m + n];
        Arrays.fill(groupSize, 1);
        for (int i = 0; i < group.length; i++) {
            if (group[i] == -1) {
                group[i] = m + i;
            }
        }
        for (int i = 0; i < group.length; i++) {
            int curGroup = group[i];
            for (int j : beforeItems.get(i)) {
                int beforeGroup = group[j];
                if (curGroup == beforeGroup) {
                    itemIndegree[i]++;
                    itemGraph[j].add(i);
                } else {
                    groupIndegree[curGroup]++;
                    groupGraph[beforeGroup].add(curGroup);
                }
            }
        }
        List<Integer> groupOrder = topSort(groupGraph, groupIndegree, groupSize);
        if (groupOrder.size() == 0) {
            return new int[0];
        }
        int[] res = new int[n];
        int index = 0;
        for (int curGroup : groupOrder) {
            int groupItemSize = 0;
            if (curGroup < m) {
                groupItemSize = 1;
            }
            List<Integer> itemOrder = topSort(itemGraph, itemIndegree, groupSize);
            if (itemOrder.size() == 0) {
                return new int[0];
            }
            for (int item : itemOrder) {
                if (group[item] == curGroup) {
                    res[index++] = item;
                }
            }
        }
        return res;
    }
}