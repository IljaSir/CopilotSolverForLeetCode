class Solution {
    public List<String> cellsInRange(String s) {
        
        String[] cells = s.split(":");
        String cell1 = cells[0], cell2 = cells[1];
        int r1 = Integer.parseInt(cell1.substring(1));
        int r2 = Integer.parseInt(cell2.substring(1));
        int c1 = cell1.charAt(0) - 'A' + 1;
        int c2 = cell2.charAt(0) - 'A' + 1;
        List<String> ans = new ArrayList<>();
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                ans.add("" + (char)('A' + j - 1) + i);
            }
        }
        return ans;
    }
}