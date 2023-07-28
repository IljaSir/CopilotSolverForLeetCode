class Solution {
    public String countOfAtoms(String formula) {
        
        int n = formula.length();
        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(new TreeMap<>());
        for (int i = 0; i < n; ) {
            char ch = formula.charAt(i);
            if (ch == '(') {
                stack.push(new TreeMap<>());
                i++;
            } else if (ch == ')') {
                Map<String, Integer> popMap = stack.pop();
                i++;
                int val = 0;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    val = val * 10 + formula.charAt(i) - '0';
                    i++;
                }
                if (val == 0) val = 1;
                Map<String, Integer> topMap = stack.peek();
                for (Map.Entry<String, Integer> entry : popMap.entrySet()) {
                    topMap.put(entry.getKey(), topMap.getOrDefault(entry.getKey(), 0) + entry.getValue() * val);
                }
            } else {
                int start = i++;
                while (i < n && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                String atom = formula.substring(start, i);
                int val = 0;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    val = val * 10 + formula.charAt(i) - '0';
                    i++;
                }
                if (val == 0) val = 1;
                Map<String, Integer> topMap = stack.peek();
                topMap.put(atom, topMap.getOrDefault(atom, 0) + val);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : stack.peek().entrySet()) {
            sb.append(entry.getKey());
            if (entry.getValue() > 1) {
                sb.append(entry.getValue());
            }
        }
        return sb.toString();
    }
}