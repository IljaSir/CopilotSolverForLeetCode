class Solution {
    public String countOfAtoms(String formula) {
        
        int n = formula.length();
        Stack<Map<String, Integer>> st = new Stack<>();
        st.push(new HashMap<>());
        for (int i = 0; i < n; i++) {
            char c = formula.charAt(i);
            if (c == '(') {
                st.push(new HashMap<>());
            } else if (c == ')') {
                Map<String, Integer> top = st.pop();
                int iStart = ++i;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int mul = iStart < i ? Integer.parseInt(formula.substring(iStart, i)) : 1;
                for (String k : top.keySet()) {
                    int v = top.get(k);
                    st.peek().put(k, st.peek().getOrDefault(k, 0) + v * mul);
                }
                i--;
            } else {
                int iStart = i++;
                while (i < n && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                String name = formula.substring(iStart, i);
                iStart = i;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int mul = iStart < i ? Integer.parseInt(formula.substring(iStart, i)) : 1;
                st.peek().put(name, st.peek().getOrDefault(name, 0) + mul);
                i--;
            }
        }
        Map<String, Integer> map = st.pop();
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        for (String k : list) {
            sb.append(k);
            int v = map.get(k);
            if (v > 1) {
                sb.append(v);
            }
        }
        return sb.toString();
    }
}