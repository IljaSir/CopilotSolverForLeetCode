class Solution {
    public List<String> basicCalculatorIV(String expression, String[] evalvars, int[] evalints) {
        
        Map<String, Integer> eval = new HashMap<>();
        for (int i = 0; i < evalvars.length; ++i) {
            eval.put(evalvars[i], evalints[i]);
        }
        return basicCalculatorIV(expression, eval);
    }
    public List<String> basicCalculatorIV(String expression, Map<String, Integer> eval) {
        String[] tokens = expression.split(" ");
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        helper(tokens, eval, map, 0, tokens.length - 1);
        for (String key : map.keySet()) {
            int val = map.get(key);
            if (val != 0) {
                result.add(val + "*" + key);
            }
        }
        Collections.sort(result, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String[] tokens1 = a.split("\\*");
                String[] tokens2 = b.split("\\*");
                if (tokens1.length != tokens2.length) {
                    return tokens2.length - tokens1.length;
                }
                for (int i = 1; i < tokens1.length; ++i) {
                    if (!tokens1[i].equals(tokens2[i])) {
                        return tokens1[i].compareTo(tokens2[i]);
                    }
                }
                return 0;
            }
        });
        return result;
    }
    private void helper(String[] tokens, Map<String, Integer> eval, Map<String, Integer> map, int start, int end) {
        if (start > end) {
            return;
        }
        if (start == end) {
            if (Character.isDigit(tokens[start].charAt(0))) {
                map.put("", map.getOrDefault("", 0) + Integer.parseInt(tokens[start]));
            } else if (eval.containsKey(tokens[start])) {
                map.put("", map.getOrDefault("", 0) + eval.get(tokens[start]));
            } else {
                map.put(tokens[start], map.getOrDefault(tokens[start], 0) + 1);
            }
            return;
        }
        if (tokens[start].equals("(")) {
            int i = start + 1;
            int count = 1;
            while (i <= end) {
                if (tokens[i].equals("(")) {
                    count++;
                } else if (tokens[i].equals(")")) {
                    count--;
                }
                if (
    }
}