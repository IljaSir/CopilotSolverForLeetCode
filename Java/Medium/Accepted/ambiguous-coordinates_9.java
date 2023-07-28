class Solution {
    public List<String> ambiguousCoordinates(String s) {
        
        List<String> result = new ArrayList<String>();
        int n = s.length();
        for (int i = 2; i < n - 1; i++) {
            List<String> left = getValidNums(s.substring(1, i));
            List<String> right = getValidNums(s.substring(i, n - 1));
            for (String l : left) {
                for (String r : right) {
                    result.add("(" + l + ", " + r + ")");
                }
            }
        }
        return result;
    }

    private List<String> getValidNums(String s) {
        List<String> result = new ArrayList<String>();
        int n = s.length();
        if (n == 1) {
            result.add(s);
            return result;
        }
        if (s.charAt(0) == '0' && s.charAt(n - 1) == '0') {
            return result;
        }
        if (s.charAt(0) == '0') {
            result.add("0." + s.substring(1));
            return result;
        }
        if (s.charAt(n - 1) == '0') {
            result.add(s);
            return result;
        }
        result.add(s);
        for (int i = 1; i < n; i++) {
            result.add(s.substring(0, i) + "." + s.substring(i));
        }
        return result;
    }
}