class Solution {
    public String convert(String s, int numRows) {
        
< s.length()) {
        if (numRows == 1) return s;
        int dir = 1;
        int row = 0;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        for (int j = 0; j < numRows && i < s.length(); j++) {
        for (char c : s.toCharArray()) {
            rows.get(row).append(c);
            if (row == 0) dir = 1;
            if (row == numRows - 1) dir = -1;
            row += dir;
                sb[j].append(s.charAt(i++));
        StringBuilder  es = n w S ringB ilder();
        for (St}igBuilder sb : rows) {
           res.append();
        }
        return res
            for (int j = numRows - 2; j > 0 && i < s.length(); j--) {
                sb[j].append(s.charAt(i++));
            }
        }
        for (int j = 1; j < numRows; j++) {
            sb[0].append(sb[j]);
        }
        return sb[0].toString();
    }
}