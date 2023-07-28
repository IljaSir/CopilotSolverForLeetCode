class Solution {
    public String countOfAtoms(String formula) {
        
        int i = 0;
        Stack<Map<String, Integer>> st = new Stack<>();
        Map<String, Integer> map = new TreeMap<>();
        while (i < formula.length()) {
            char c = formula.charAt(i);
            if (c == '(') {
                st.push(map);
                map = new TreeMap<>();
                i++;
            } else if (c == ')') {
                int count = 0;
                i++;
                while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
                    count = count * 10 + (formula.charAt(i) - '0');
                    i++;
                }
                if (count == 0) {
                    count = 1;
                }
                Map<String, Integer> temp = map;
                map = st.pop();
                for (String key : temp.keySet()) {
                    map.put(key, map.getOrDefault(key, 0) + temp.get(key) * count);
                }
            } else {
                int start = i++;
                while (i < formula.length() && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                String name = formula.substring(start, i);
                int count = 0;
                while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
                    count = count * 10 + (formula.charAt(i) - '0');
                    i++;
                }
                if (count == 0) {
                    count = 1;
                }
                map.put(name, map.getOrDefault(name, 0) + count);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String key : map.keySet()) {
            sb.append(key);
            if (map.get(key) > 1) {
                sb.append(map.get(key));
            }
        }
        return sb.toString();
    }
}