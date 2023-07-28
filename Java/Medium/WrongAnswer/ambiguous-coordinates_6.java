class Solution {
    public List<String> ambiguousCoordinates(String s) {
        
        List<String> result = new ArrayList<>();
        int n = s.length();
        for (int i = 2; i < n - 1; i++) {
            List<String> left = helper(s.substring(1, i));
            List<String> right = helper(s.substring(i, n - 1));
            for (String l : left) {
                for (String r : right) {
                    result.add("(" + l + ", " + r + ")");
                }
            }
        }
        return result;
    }
    
    private List<String> helper(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() == 1) {
            result.add(s);
            return result;
        }
        if (s.charAt(0) != '0') {
            result.add(s);
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(0) == '0' && s.charAt(i) != '0') {
                break;
            }
            String left = s.substring(0, i);
            String right = s.substring(i);
            if (right.charAt(right.length() - 1) != '0') {
                result.add(left + "." + right);
            }
        }
        return result;
    }
}