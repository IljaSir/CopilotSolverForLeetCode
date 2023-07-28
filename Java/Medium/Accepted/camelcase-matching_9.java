class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        
        List<Boolean> res = new ArrayList<>();
        for (String query : queries) {
            int index = 0;
            boolean match = true;
            for (int i = 0; i < query.length(); i++) {
                if (index < pattern.length() && query.charAt(i) == pattern.charAt(index)) {
                    index++;
                } else if (Character.isUpperCase(query.charAt(i))) {
                    match = false;
                    break;
                }
            }
            if (index != pattern.length()) {
                match = false;
            }
            res.add(match);
        }
        return res;
    }
}