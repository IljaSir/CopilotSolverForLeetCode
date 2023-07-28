class Solution {
    public String reformat(String s) {
        
        StringBuilder sb = new StringBuilder();
        List<Character> letters = new ArrayList<>();
        List<Character> digits = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                digits.add(s.charAt(i));
            } else {
                letters.add(s.charAt(i));
            }
        }
        if (Math.abs(digits.size() - letters.size()) > 1) {
            return "";
        }
        if (digits.size() > letters.size()) {
            for (int i = 0; i < digits.size(); i++) {
                sb.append(digits.get(i));
                if (i < letters.size()) {
                    sb.append(letters.get(i));
                }
            }
        } else {
            for (int i = 0; i < letters.size(); i++) {
                sb.append(letters.get(i));
                if (i < digits.size()) {
                    sb.append(digits.get(i));
                }
            }
        }
        return sb.toString();
    }
}