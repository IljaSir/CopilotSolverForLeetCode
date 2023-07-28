class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        
        int n = names.length;
        Map<Integer, List<String>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<String> list = map.getOrDefault(heights[i], new ArrayList<>());
            list.add(names[i]);
            map.put(heights[i], list);
        }
        Arrays.sort(heights);
        int k = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            List<String> list = map.get(heights[i]);
            Collections.sort(list);
            for (int j = 0; j < list.size(); j++) {
                names[k--] = list.get(j);
            }
        }
        return names;
    }
}