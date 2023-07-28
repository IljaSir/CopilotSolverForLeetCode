class Solution {
    public List<String> ambiguousCoordinates(String s) {
        
        List<String> result = new ArrayList<>();
        for (int i = 2; i < s.length() - 1; i++) {
            List<String> left = getValid(s.substring(1, i));
            List<String> right = getValid(s.substring(i, s.length() - 1));
            for (String l : left) {
                for (String r : right) {
                    result.add("(" + l + ", " + r + ")");
                }
            }
        }
        return result;
    }
    
    private List<String> getValid(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() == 1) {
            result.add(s);
            return result;
        }
        
        if (s.charAt(0) != '0') {
            result.add(s);
        }
        
        for (int i = 1; i < s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i);
            if (left.charAt(0) == '0' && left.charAt(left.length() - 1) == '0') {
                continue;
            }
            if (right.charAt(right.length() - 1) == '0') {
                continue;
            }
            result.add(left + "." + right);
        }
        return result;
    }
}