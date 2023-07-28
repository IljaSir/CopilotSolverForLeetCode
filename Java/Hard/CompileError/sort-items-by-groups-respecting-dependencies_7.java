class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        
        int[] res = new int[n];
        int[] itemGroup = new int[n];
        int[] groupInDegree = new int[m];
        int[] itemInDegree = new int[n];
        int[] groupOutDegree = new int[m];
        int[] itemOutDegree = new int[n];
        int[] groupCount = new int[m];
        int[] itemCount = new int[m];
        int[] groupIndex = new int[m];
        int[] itemIndex = new int[n];
        int[] groupRes = new int[m];
        int[] itemRes = new int[n];
        int[] itemGroupCount = new int[m];
        int[] itemGroupIndex = new int[m];
        int[] itemGroupRes = new int[m];
        int groupNum = m;
        int itemNum = n;
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = groupNum++;
            }
            itemGroup[i] = group[i];
            groupCount[group[i]]++;
        }
        for (int i = 0; i < n; i++) {
            int g = group[i];
            int c = groupCount[g];
            groupIndex[g] = i - c + 1;
            itemIndex[i] = i;
        }
        for (int i = 0; i < n; i++) {
            int g = group[i];
            int c = groupCount[g];
            int index = groupIndex[g];
            groupRes[index + itemGroupCount[g]] = i;
            itemGroupRes[index + itemGroupCount[g]] = g;
            itemGroupCount[g]++;
        }
        for (int i = 0; i < n; i++) {
            int g = group[i];
            int c = groupCount[g];
            int index = groupIndex[g];
            int item = groupRes[i];
            for (int j = 0; j < beforeItems.get(item).size(); j++) {
                int beforeItem = beforeItems.get(item).get(j);
                int beforeGroup = group[beforeItem];
                if (beforeGroup == g) {
                    itemInDegree[i]++;
                    itemOutDegree[index + itemIndex[beforeItem]]++;
                } else {
                    groupInDegree[g]++;
                    groupOutDegree[groupIndex[beforeGroup] + itemGroupIndex[beforeGroup]]
    }
}