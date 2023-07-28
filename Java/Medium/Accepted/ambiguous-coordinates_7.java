class Solution {
    public List<String> ambiguousCoordinates(String s) {
        
        List<String> res = new ArrayList<>();
        s = s.substring(1, s.length() - 1);
        for (int i = 1; i < s.length(); i++) {
            List<String> left = generateValid(s.substring(0, i));
            List<String> right = generateValid(s.substring(i));
            for (String l : left) {
                for (String r : right) {
                    res.add("(" + l + ", " + r + ")");
                }
            }
        }
        return res;
    }

    private List<String> generateValid(String s) {
        List<String> res = new ArrayList<>();
        int n = s.length();
        if (n == 0 || n > 1 && s.charAt(0) == '0' && s.charAt(n - 1) == '0') {
            return res;
        }
        if (n > 1 && s.charAt(0) == '0') {
            res.add("0." + s.substring(1));
            return res;
        }
        if (s.charAt(n - 1) == '0') {
            res.add(s);
            return res;
        }
        res.add(s);
        for (int i = 1; i < n; i++) {
            res.add(s.substring(0, i) + "." + s.substring(i));
        }
        return res;
    }
}