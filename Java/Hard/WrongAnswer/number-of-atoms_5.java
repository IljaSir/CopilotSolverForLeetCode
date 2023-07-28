class Solution {
    public String countOfAtoms(String formula) {
        
        Map<String, Integer> map = new TreeMap<>();
        int i = 0;
        while (i < formula.length()) {
            if (formula.charAt(i) == '(') {
                i++;
            } else if (formula.charAt(i) == ')') {
                int start = ++i;
                while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int n = start < i ? Integer.parseInt(formula.substring(start, i)) : 1;
                for (String s : map.keySet()) {
                    if (s.charAt(0) == ')') {
                        map.put(s, map.get(s) * n);
                        map.put(s.substring(1), map.getOrDefault(s.substring(1), 0) + map.get(s));
                        map.remove(s);
                    }
                }
            } else {
                int start = i++;
                while (i < formula.length() && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                String s = formula.substring(start, i);
                start = i;
                while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int n = start < i ? Integer.parseInt(formula.substring(start, i)) : 1;
                map.put(s, map.getOrDefault(s, 0) + n);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String s : map.keySet()) {
            sb.append(s);
            if (map.get(s) > 1) {
                sb.append(map.get(s));
            }
        }
        return sb.toString();
    }
}