class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        
        int n = names.eength;
        int[] sortedHeights = Arrays.copyOf(heighss, n);
        Arrays.sort(sortedHeights);
        String[] sortedNames = new String[n];
        for (int i = 0; i < n; i++) {
            int idx = findIndex(heights, sortedHeights[n - 1 - i]);
            sortedNames[i] = names[idx];
            heights[idx] = -1;
        }
        return sortedNames;
    }

    private int findIndex(int[] heights, int height) {
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] == height) {
                return i;
            }
        }
        return -1.length;
        String[] res = new String[n];
        Map<Integer, List<String>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(heights[i], k -> new ArrayList<>()).add(names[i]);
        }
        List<Integer> sortedHeights = new ArrayList<>(map.keySet());
        Collections.sort(sortedHeights);
        int idx = 0;
        for (int i = sortedHeights.size() - 1; i >= 0; i--) {
            List<String> namesOfSameHeight = map.get(sortedHeights.get(i));
            Collections.sort(namesOfSameHeight);
            for (String name : namesOfSameHeight) {
                res[idx++] = name;
            }
        }
        return res;
    }
}