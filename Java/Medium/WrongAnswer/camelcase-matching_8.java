class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        
        List<Boolean> result = new ArrayList<Boolean>();
        for (String query : queries) {
            result.add(match(query, pattern));
        }
        return result;
    }

    private boolean match(String query, String pattern) {
        int i = 0, j = 0;
        while (i < query.length() && j < pattern.length()) {
            if (Character.isUpperCase(query.charAt(i))) {
                if (query.charAt(i) != pattern.charAt(j)) {
                    return false;
                }
                j++;
            }
            i++;
        }
        while (i < query.length()) {
            if (Character.isUpperCase(query.charAt(i))) {
                return false;
            }
            i++;
        }
        return j == pattern.length();
    }
}