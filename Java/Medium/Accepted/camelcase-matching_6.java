class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        
        List<Boolean> res = new ArrayList<>();
        for (String s : queries) {
            int i = 0;
            for (char c : s.toCharArray()) {
                if (i < pattern.length() && c == pattern.charAt(i)) {
                    i++;
                } else if (Character.isUpperCase(c)) {
                    i = -1;
                    break;
                }
            }
            res.add(i == pattern.length());
        }
        return res;
    }
}