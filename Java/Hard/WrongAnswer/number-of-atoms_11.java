class Solution {
    public String countOfAtoms(String formula) {
        
        Map<String, Integer> counts = countOfAtoms(formula, 0, formula.length());
        StringBuilder sb = new StringBuilder();
        for (String name : counts.keySet().stream().sorted().collect(Collectors.toList())) {
            sb.append(name);
            int multiplicity = counts.get(name);
            if (multiplicity > 1) {
                sb.append(multiplicity);
            }
        }
        return sb.toString();
    }
    private Map<String, Integer> countOfAtoms(String formula, int start, int end) {
        Map<String, Integer> counts = new TreeMap<>();
        for (int i = start; i < end; ) {
            if (formula.charAt(i) == '(') {
                int j = i, balance = 0;
                do {
                    if (formula.charAt(j) == '(') {
                        balance++;
                    } else if (formula.charAt(j) == ')') {
                        balance--;
                    }
                    j++;
                } while (balance > 0);
                Map<String, Integer> inside = countOfAtoms(formula, i + 1, j - 1);
                int multiplicity = parseMultiplicity(formula, j, end);
                for (String name : inside.keySet()) {
                    counts.put(name, counts.getOrDefault(name, 0) + multiplicity * inside.get(name));
                }
                i = j + String.valueOf(multiplicity).length();
            } else {
                int j = i + 1;
                while (j < end && Character.isLowerCase(formula.charAt(j))) {
                    j++;
                }
                String name = formula.substring(i, j);
                int multiplicity = parseMultiplicity(formula, j, end);
                counts.put(name, counts.getOrDefault(name, 0) + multiplicity);
                i = j + String.valueOf(multiplicity).length();
            }
        }
        return counts;
    }
    private int parseMultiplicity(String formula, int start, int end) {
        int i = start;
        while (i < end && Character.isDigit(formula.charAt(i))) {
            i++;
        }
        return i > start ? Integer.parseInt(formula.substring(start, i)) : 1;
    }
}