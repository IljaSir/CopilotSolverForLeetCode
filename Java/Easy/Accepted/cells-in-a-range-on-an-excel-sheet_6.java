class Solution {
    public List<String> cellsInRange(String s) {
        
        String[] cols = s.split(":");
        int col1 = getCol(cols[0]);
        int col2 = getCol(cols[1]);
        int row1 = Integer.parseInt(cols[0].substring(1));
        int row2 = Integer.parseInt(cols[1].substring(1));
        List<String> ans = new ArrayList<>();
        for (int i = col1; i <= col2; i++) {
            for (int j = row1; j <= row2; j++) {
                ans.add(getColName(i) + j);
            }
        }
        return ans;
    }
    private String getColName(int col) {
        StringBuilder sb = new StringBuilder();
        while (col > 0) {
            int c = (col - 1) % 26;
            sb.append((char)('A' + c));
            col = (col - 1) / 26;
        }
        return sb.reverse().toString();
    }
    private int getCol(String s) {
        int ans = 0;
        for (char c : s.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                ans = ans * 26 + (c - 'A' + 1);
            }
        }
        return ans;
    }
}