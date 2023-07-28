class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        
        String[] result = new String[names.length];
        int[] sortedHeights = Arrays.copyOf(heights, heights.length);
        Arrays.sort(sortedHeights);
        Map<Integer, List<String>> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            if (!map.containsKey(heights[i])) {
                map.put(heights[i], new ArrayList<>());
            }
            map.get(heights[i]).add(names[i]);
        }
        for (int i = sortedHeights.length - 1; i >= 0; i--) {
            List<String> namesOfThisHeight = map.get(sortedHeights[i]);
            Collections.sort(namesOfThisHeight);
            for (String name : namesOfThisHeight) {
                result[sortedHeights.length - 1 - i] = name;
                i--;
            }
        }
        return result;
    }
}