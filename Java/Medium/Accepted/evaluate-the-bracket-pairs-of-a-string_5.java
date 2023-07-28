class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        
        Map<String, String> map = new HashMap<>();
        for (List<String> kv : knowledge) {
            map.put(kv.get(0), kv.get(1));
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '(') {
                int j = i + 1;
                while (j < s.length() && s.charAt(j) != ')') {
                    j++;
                }
                String key = s.substring(i + 1, j);
                sb.append(map.getOrDefault(key, "?"));
                i = j + 1;
            } else {
                sb.append(c);
                i++;
            }
        }
        return sb.toString();
    }
}