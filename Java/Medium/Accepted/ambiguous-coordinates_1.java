class Solution {
    public List<String> ambiguousCoordinates(String s) {
        
        List<String> res = new ArrayList<String>();
        for (int i = 2; i < s.length() - 1; ++i) {
            List<String> A = f(s.substring(1, i)), B = f(s.substring(i, s.length() - 1));
            for (String a: A) for (String b: B)
                res.add("(" + a + ", " + b + ")");
        }
        return res;
    }
    public List<String> f(String s) {
        int n = s.length();
        List<String> res = new ArrayList<String>();
        for (int i = 1; i <= n; ++i) {
            String left = s.substring(0, i), right = s.substring(i);
            if ((!left.startsWith("0") || left.equals("0")) && !right.endsWith("0"))
                res.add(left + (i == n ? "" : ".") + right);
        }
        return res;
    }
}