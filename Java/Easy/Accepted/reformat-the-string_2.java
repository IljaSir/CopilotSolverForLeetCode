class Solution {
    public String reformat(String s) {
        
        int n = s.length();
        List<Character> digits = new ArrayList<>();
        List<Character> letters = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (Character.isDigit(s.charAt(i))) {
                digits.add(s.charAt(i));
            } else {
                letters.add(s.charAt(i));
            }
        }
        if (Math.abs(digits.size() - letters.size()) > 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (digits.size() > letters.size()) {
            for (int i = 0; i < letters.size(); i++) {
                sb.append(digits.get(i));
                sb.append(letters.get(i));
            }
            sb.append(digits.get(digits.size() - 1));
        } else {
            for (int i = 0; i < digits.size(); i++) {
                sb.append(letters.get(i));
                sb.append(digits.get(i));
            }
            if (digits.size() < letters.size()) {
                sb.append(letters.get(letters.size() - 1));
            }
        }
        return sb.toString();
    }
}