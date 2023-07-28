class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        
        String res = "";
        for (String d : dictionary) {
            if (check(s, d)) {
                if (d.length() > res.length() || (d.length() == res.length() && d.compareTo(res) < 0)) {
                    res = d;
                }
            }
        }
        return res;
    }
    boolean check(String s, String d) {
        int i = 0;
        for (char c : s.toCharArray()) {
            if (i < d.length() && c == d.charAt(i)) {
                i++;
            }
        }
        return i == d.length();
    }
}