class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        
        List<String> result = new ArrayList<String>();
        for (String q : queries) {
            boolean found = false;
            for (String d : dictionary) {
                if (q.length() == d.length()) {
                    if (oneEdit(q, d)) {
                        found = true;
                        break;
                    }
                } else if (q.length() == d.length() + 1) {
                    if (oneEdit(d, q)) {
                        found = true;
                        break;
                    }
                } else if (q.length() == d.length() - 1) {
                    if (oneEdit(q, d)) {
                        found = true;
                        break;
                    }
                }
            }
            if (found) {
                result.add(q);
            }
        }
        return result;
    }

    private boolean oneEdit(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }
}
    }
}