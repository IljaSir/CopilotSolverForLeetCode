class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        
        int n = names.length;
        String[] result = new String[n];
        Map<Integer, List<String>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int height = heights[i];
            List<String> list = map.getOrDefault(height, new ArrayList<>());
            list.add(names[i]);
            map.put(height, list);
        }
        Arrays.sort(heights);
        int index = n - 1;
        for (int i = 0; i < n; i++) {
            int height = heights[i];
            List<String> list = map.get(height);
            Collections.sort(list);
            for (String name : list) {
                result[index--] = name;
            }
        }
        return result;
    }
}