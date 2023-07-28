class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        
        Map<String, String> map = new HashMap<>();
        for (List<String> list : knowledge) {
            map.put(list.get(0), list.get(1));
        }
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while (idx < s.length()) {
            char c = s.charAt(idx);
            if (c == '(') {
                int next = s.indexOf(')', idx + 1);
                String key = s.substring(idx + 1, next);
                sb.append(map.getOrDefault(key, "?"));
                idx = next + 1;
            } else {
                sb.append(c);
                idx++;
            }
        }
        return sb.toString();
    }
}