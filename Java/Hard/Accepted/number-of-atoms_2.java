class Solution {
    public String countOfAtoms(String formula) {
        
        Map<String, Integer> map = new TreeMap<>();
        Stack<Map<String, Integer>> stack = new Stack<>();
        int i = 0;
        while (i < formula.length()) {
            char c = formula.charAt(i);
            if (c == '(') {
                stack.push(map);
                map = new TreeMap<>();
                i++;
            } else if (c == ')') {
                int start = ++i;
                while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int count = start < i ? Integer.parseInt(formula.substring(start, i)) : 1;
                Map<String, Integer> top = stack.pop();
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    top.put(entry.getKey(), top.getOrDefault(entry.getKey(), 0) + entry.getValue() * count);
                }
                map = top;
            } else {
                int start = i++;
                while (i < formula.length() && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                String key = formula.substring(start, i);
                start = i;
                while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int count = start < i ? Integer.parseInt(formula.substring(start, i)) : 1;
                map.put(key, map.getOrDefault(key, 0) + count);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            sb.append(entry.getKey());
            if (entry.getValue() > 1) {
                sb.append(entry.getValue());
            }
        }
        return sb.toString();
    }
}