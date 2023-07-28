class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        
        List<Boolean> res = new ArrayList<>();
        for (String q : queries) {
            res.add(isMatch(q, pattern));
        }
        return res;
    }
    private boolean isMatch(String q, String p) {
        int i = 0, j = 0;
        while (i < q.length()) {
            if (j < p.length() && q.charAt(i) == p.charAt(j)) {
                j++;
            } else if (q.charAt(i) < 'a') {
                return false;
            }
            i++;
        }
        return j == p.length();
    }
}