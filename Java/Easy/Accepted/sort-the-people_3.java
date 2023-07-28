class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        
        int n = names.length;
        String[] res = new String[n];
        HashMap<Integer, List<String>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(heights[i])) {
                map.put(heights[i], new ArrayList<>());
            }
            map.get(heights[i]).add(names[i]);
        }
        Arrays.sort(heights);
        int idx = 0;
        for (int i = n - 1; i >= 0; i--) {
            List<String> list = map.get(heights[i]);
            Collections.sort(list);
            for (String s : list) {
                res[idx++] = s;
            }
        }
        return res;
    }
}