class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        
        int n = s.length();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }

        for (List<Integer> pair : pairs) {
            int x = find(p, pair.get(0));
            int y = find(p, pair.get(1));
            p[x] = y;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = find(p, i);
            List<Integer> list = map.getOrDefault(x, new ArrayList<>());
            list.add(i);
            map.put(x, list);
        }

        StringBuilder sb = new StringBuilder(s);
        for (List<Integer> list : map.values()) {
            char[] chars = new char[list.size()];
            for (int i = 0; i < list.size(); i++) {
                chars[i] = s.charAt(list.get(i));
            }
            Arrays.sort(chars);
            for (int i = 0; i < list.size(); i++) {
                sb.setCharAt(list.get(i), chars[i]);
            }
        }

        return sb.toString();
    }

    private int find(int[] p, int i) {
        if (p[i] != i) {
            p[i] = find(p, p[i]);
        }
        return p[i];
    }
}