class Solution {
    public int numDifferentIntegers(String word) {
        
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Character.isDigit(c)) {
                sb.append(c);
            } else {
                if (sb.length() > 0) {
                    set.add(sb.toString());
                    sb.setLength(0);
                }
            }
        }
        if (sb.length() > 0) {
            set.add(sb.toString());
        }
        return set.size();
    }
}