class Solution {
    public int numDifferentIntegers(String word) {
        
        int n = word.length();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (Character.isDigit(word.charAt(i))) {
                StringBuilder sb = new StringBuilder();
                while (i < n && Character.isDigit(word.charAt(i))) {
                    sb.append(word.charAt(i));
                    i++;
                }
                while (sb.length() > 1 && sb.charAt(0) == '0') {
                    sb.deleteCharAt(0);
                }
                set.add(sb.toString());
            }
        }
        return set.size();
    }
}