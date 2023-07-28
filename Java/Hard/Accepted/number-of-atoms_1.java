class Solution {
    public String countOfAtoms(String formula) {
        
        Stack<Map<String, Integer>> stack = new Stack<>();
        Map<String, Integer> map = new HashMap<>();
        int n = formula.length();
        int i = 0;
        while (i < n) {
            char c = formula.charAt(i);
            if (c == '(') {
                stack.push(map);
                map = new HashMap<>();
                i++;
            } else if (c == ')') {
                int start = ++i;
                while (i < n && Character.isDigit(formula.charAt(i))) i++;
                int mul = start < i ? Integer.parseInt(formula.substring(start, i)) : 1;
                Map<String, Integer> prev = stack.pop();
                for (String s : map.keySet()) {
                    prev.put(s, prev.getOrDefault(s, 0) + map.get(s) * mul);
                }
                map = prev;
            } else {
                int start = i++;
                while (i < n && Character.isLowerCase(formula.charAt(i))) i++;
                String s = formula.substring(start, i);
                start = i;
                while (i < n && Character.isDigit(formula.charAt(i))) i++;
                int mul = start < i ? Integer.parseInt(formula.substring(start, i)) : 1;
                map.put(s, map.getOrDefault(s, 0) + mul);
            }
        }
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        for (String s : list) {
            sb.append(s);
            int count = map.get(s);
            if (count > 1) sb.append(count);
        }
        return sb.toString();
    }
}