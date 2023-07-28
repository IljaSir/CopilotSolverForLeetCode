class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        
        int n = names.length;
        String[] sortedNames = new String[n];
        Map<Integer, List<String>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(heights[i])) {
                map.get(heights[i]).add(names[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(names[i]);
                map.put(heights[i], list);
            }
        }
        Arrays.sort(heights);
        int j = 0;
        for (int i = n - 1; i >= 0; i--) {
            List<String> list = map.get(heights[i]);
            Collections.sort(list);
            for (String name : list) {
                sortedNames[j++] = name;
            }
        }
        return sortedNames;
    }
}