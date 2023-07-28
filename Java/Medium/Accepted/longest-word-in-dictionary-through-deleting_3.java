class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        
        String ans = "";
        for (String t : dictionary) {
            int i = 0;
            for (char c : s.toCharArray())
                if (i < t.length() && c == t.charAt(i))
                    i++;
            if (i == t.length() && t.length() >= ans.length()) {
                if (t.length() > ans.length() || t.compareTo(ans) < 0)
                    ans = t;
            }
        }
        return ans;
    }
}