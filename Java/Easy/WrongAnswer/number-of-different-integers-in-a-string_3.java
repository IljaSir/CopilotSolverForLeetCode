class Solution {
    public int numDifferentIntegers(String word) {
        
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
            } else if (sb.length() > 0) {
                set.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        if (sb.length() > 0) {
            set.add(sb.toString());
        }
        return set.size();
    }
}