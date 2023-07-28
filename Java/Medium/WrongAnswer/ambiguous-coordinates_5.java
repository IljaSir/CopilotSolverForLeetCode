class Solution {
    public List<String> ambiguousCoordinates(String s) {
        
        List<String> result = new ArrayList<>();
        for (int i = 2; i < s.length() - 1; i++) {
            List<String> left = generate(s, 1, i);
            List<String> right = generate(s, i, s.length() - 1);
            for (String l : left) {
                for (String r : right) {
                    result.add("(" + l + ", " + r + ")");
                }
            }
        }
        return result;
    }
    private List<String> generate(String s, int start, int end) {
        List<String> result = new ArrayList<>();
        for (int i = start; i < end; i++) {
            String left = s.substring(start, i);
            String right = s.substring(i, end);
            if ((left.length() > 1 && left.charAt(0) == '0' && left.charAt(left.length() - 1) == '0') ||
                (right.length() > 1 && right.charAt(0) == '0' && right.charAt(right.length() - 1) == '0')) {
                continue;
            }
            if (left.length() > 1 && left.charAt(0) == '0') {
                left = "0." + left.substring(1);
            }
            if (right.length() > 1 && right.charAt(right.length() - 1) == '0') {
                right = right.substring(0, right.length() - 1);
            }
            result.add(left + right);
        }
        if (s.charAt(end - 1) != '0') {
            result.add(s.substring(start, end));
        }
        return result;
    }
}