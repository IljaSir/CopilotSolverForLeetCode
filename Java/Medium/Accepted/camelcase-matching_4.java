class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        
        List<Boolean> ans = new ArrayList<>();
        for (String query : queries) {
            ans.add(isMatch(query, pattern));
        }
        return ans;
    }

    private boolean isMatch(String query, String pattern) {
        int i = 0, j = 0;
        while (i < query.length()) {
            if (j < pattern.length() && query.charAt(i) == pattern.charAt(j)) {
                j++;
            } else if (query.charAt(i) >= 'A' && query.charAt(i) <= 'Z') {
                return false;
            }
            i++;
        }
        return j == pattern.length();
    }
}