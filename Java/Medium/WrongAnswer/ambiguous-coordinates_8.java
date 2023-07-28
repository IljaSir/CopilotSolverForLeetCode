class Solution {
    public List<String> ambiguousCoordinates(String s) {
        
        List<String> res = new ArrayList<>();
        for (int i = 2; i < s.length() - 1; i++) {
            List<String> left = getValidCoordinate(s.substring(1, i));
            List<String> right = getValidCoordinate(s.substring(i, s.length() - 1));
            for (String l : left) {
                for (String r : right) {
                    res.add("(" + l + ", " + r + ")");
                }
            }
        }
        return res;
    }
    private List<String> getValidCoordinate(String s) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i);
            if ((left.length() > 1 && left.charAt(0) == '0' && left.charAt(left.length() - 1) == '0') || (right.length() > 0 && right.charAt(right.length() - 1) == '0')) {
                continue;
            }
            res.add(left + (i < s.length() ? "." : "") + right);
        }
        return res;
    }
}