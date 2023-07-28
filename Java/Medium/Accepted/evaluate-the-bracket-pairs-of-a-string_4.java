class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        
        Map<String, String> map = new HashMap<>();
        for (List<String> list : knowledge) {
            map.put(list.get(0), list.get(1));
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                int j = i + 1;
                while (s.charAt(j) != ')') {
                    j++;
                }
                String key = s.substring(i + 1, j);
                if (map.containsKey(key)) {
                    sb.append(map.get(key));
                } else {
                    sb.append('?');
                }
                i = j + 1;
            } else {
                sb.append(s.charAt(i++));
            }
        }
        return sb.toString();
    }
}