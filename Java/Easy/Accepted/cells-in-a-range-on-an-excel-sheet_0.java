class Solution {
    public List<String> cellsInRange(String s) {
        
        String[] cells = s.split(":");
        String[] cell1 = cells[0].split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
        String[] cell2 = cells[1].split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
        List<String> result = new ArrayList<>();
        int c1 = cell1[0].charAt(0) - 'A' + 1;
        int c2 = cell2[0].charAt(0) - 'A' + 1;
        int r1 = Integer.parseInt(cell1[1]);
        int r2 = Integer.parseInt(cell2[1]);
        for (int i = c1; i <= c2; i++) {
            for (int j = r1; j <= r2; j++) {
                result.add((char) (i + 'A' - 1) + Integer.toString(j));
            }
        }
        return result;
    }
}