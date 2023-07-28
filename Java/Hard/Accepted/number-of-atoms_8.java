class Solution {
    public String countOfAtoms(String formula) {
        
        int[] index = new int[1];
        Map<String, Integer> map = parse(formula, index);
        StringBuilder sb = new StringBuilder();
        for (String key : map.keySet()) {
            sb.append(key);
            if (map.get(key) > 1) {
                sb.append(map.get(key));
            }
        }
        return sb.toString();
    }
    public Map<String, Integer> parse(String formula, int[] index) {
        Map<String, Integer> map = new TreeMap<>();
        int n = formula.length();
        while (index[0] < n) {
            char c = formula.charAt(index[0]);
            if (c == '(') {
                index[0]++;
                Map<String, Integer> sub = parse(formula, index);
                index[0]++;
                int num = getNum(formula, index);
                for (String key : sub.keySet()) {
                    map.put(key, map.getOrDefault(key, 0) + sub.get(key) * num);
                }
            } else if (c == ')') {
                return map;
            } else {
                String key = getKey(formula, index);
                int num = getNum(formula, index);
                map.put(key, map.getOrDefault(key, 0) + num);
            }
        }
        return map;
    }
    public String getKey(String formula, int[] index) {
        int n = formula.length();
        StringBuilder sb = new StringBuilder();
        sb.append(formula.charAt(index[0]++));
        while (index[0] < n && Character.isLowerCase(formula.charAt(index[0]))) {
            sb.append(formula.charAt(index[0]++));
        }
        return sb.toString();
    }
    public int getNum(String formula, int[] index) {
        int n = formula.length();
        if (index[0] == n || !Character.isDigit(formula.charAt(index[0]))) {
            return 1;
        }
        int num = 0;
        while (index[0] < n && Character.isDigit(formula.charAt(index[0]))) {
            num = num * 10 + formula.charAt(index[0]++) - '0';
        }
        return num;
    }
}