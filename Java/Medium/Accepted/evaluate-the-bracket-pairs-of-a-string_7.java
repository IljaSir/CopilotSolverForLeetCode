class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        
        Map<String, String> map = new HashMap<>();
        for (List<String> list : knowledge) {
            map.put(list.get(0), list.get(1));
        }
        StringBuilder sb = new StringBuilder();
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '(') {
                int j = i + 1;
                while (cs[j] != ')') {
                    j++;
                }
                String key = s.substring(i + 1, j);
                sb.append(map.getOrDefault(key, "?"));
                i = j;
            } else {
                sb.append(cs[i]);
            }
        }
        return sb.toString();
    }
}