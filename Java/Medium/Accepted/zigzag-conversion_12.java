class Solution {
    public String convert(String s, int numRows) {
        
        if (numRows == 1) return s;
        int dir = 1;
        int row = 0;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        for (char c : s.toCharArray()) {
            rows.get(row).append(c);
            if (row == 0) dir = 1;
            if (row == numRows - 1) dir = -1;
            row += dir;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : rows) {
            res.append(sb);
        }
        return res.toString();
    }
}