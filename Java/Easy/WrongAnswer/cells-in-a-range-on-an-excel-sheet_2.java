class Solution {
    public List<String> cellsInRange(String s) {
        
        String[] cells = s.split(":");
        String c1 = cells[0].substring(0, cells[0].length() - 1);
        String r1 = cells[0].substring(cells[0].length() - 1);
        String c2 = cells[1].substring(0, cells[1].length() - 1);
        String r2 = cells[1].substring(cells[1].length() - 1);
        int c1i = c1.charAt(0) - 'A' + 1;
        int r1i = Integer.parseInt(r1);
        int c2i = c2.charAt(0) - 'A' + 1;
        int r2i = Integer.parseInt(r2);
        List<String> result = new ArrayList<>();
        for (int i = r1i; i <= r2i; i++) {
            for (int j = c1i; j <= c2i; j++) {
                char c = (char)('A' + j - 1);
                result.add("" + c + i);
            }
        }
        return result;
    }
}