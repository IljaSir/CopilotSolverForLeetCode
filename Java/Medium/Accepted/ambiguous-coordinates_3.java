class Solution {
    public List<String> ambiguousCoordinates(String s) {
        
        int n = s.length();
        List<String> res = new ArrayList<>();
        for (int i = 2; i < n - 1; i++) {
            List<String> A = f(s.substring(1, i)), B = f(s.substring(i, n - 1));
            for (String a : A) for (String b : B) res.add("(" + a + ", " + b + ")");
        }
        return res;
    }
    List<String> f(String s) {
        int n = s.length();
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String L = s.substring(0, i), R = s.substring(i);
            if ((!L.startsWith("0") || L.equals("0")) && !R.endsWith("0")) res.add(L + (i == n ? "" : "." + R));
        }
        return res;
    }
}