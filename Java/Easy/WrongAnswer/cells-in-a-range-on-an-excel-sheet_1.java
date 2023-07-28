class Solution {
    public List<String> cellsInRange(String s) {
        
        String[] cells = s.split(":");
        String[] cell1 = cells[0].split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
        String[] cell2 = cells[1].split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
        int col1 = cell1[0].chars().reduce(0, (a, b) -> a * 26 + b - 'A' + 1);
        int col2 = cell2[0].chars().reduce(0, (a, b) -> a * 26 + b - 'A' + 1);
        int row1 = Integer.parseInt(cell1[1]);
        int row2 = Integer.parseInt(cell2[1]);
        List<String> result = new ArrayList<>();
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                result.add(getColumn(j) + i);
            }
        }
        return result;
    }
    private String getColumn(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.append((char) ('A' + n % 26));
            n /= 26;
        }
        return sb.reverse().toString();
    }
}