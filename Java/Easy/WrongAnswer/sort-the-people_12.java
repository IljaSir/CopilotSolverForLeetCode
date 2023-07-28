class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        
        // Sort the height array
        // Use the sorted height array to sort the names array
        int[] sortedHeights = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            sortedHeights[i] = heights[i];
        }
        Arrays.sort(sortedHeights);
        Map<Integer, List<String>> map = new HashMap<>();
        for (int i = 0; i < sortedHeights.length; i++) {
            int height = sortedHeights[i];
            List<String> list = map.getOrDefault(height, new ArrayList<>());
            list.add(names[i]);
            map.put(height, list);
        }
        // Sort the names in descending order
        String[] sortedNames = new String[names.length];
        int i = 0;
        for (int j = sortedHeights.length - 1; j >= 0; j--) {
            int height = sortedHeights[j];
            List<String> list = map.get(height);
            Collections.sort(list);
            for (String name : list) {
                sortedNames[i++] = name;
            }
        }
        return sortedNames;
    }
}