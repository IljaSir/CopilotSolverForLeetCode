class Solution {
    public String countOfAtoms(String formula) {
        
        Map<String, Integer> map = new TreeMap<>();
        Stack<Map<String, Integer>> stack = new Stack<>();
        int i = 0;
        while (i < formula.length()) {
            char c = formula.charAt(i);
            i++;
            if (c == '(') {
                stack.push(map);
                map = new TreeMap<>();
            } else if (c == ')') {
                int start = i;
                while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int count = start == i ? 1 : Integer.parseInt(formula.substring(start, i));
                Map<String, Integer> map2 = map;
                map = stack.pop();
                for (Map.Entry<String, Integer> entry : map2.entrySet()) {
                    map.put(entry.getKey(), map.getOrDefault(entry.getKey(), 0) + entry.getValue() * count);
                }
            } else {
                int start = i - 1;
                while (i < formula.length() && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                String s = formula.substring(start, i);
                start = i;
                while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int count = start == i ? 1 : Integer.parseInt(formula.substring(start, i));
                map.put(s, map.getOrDefault(s, 0) + count);
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