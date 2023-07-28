class Solution {
    public List<String> cellsInRange(String s) {
        
        int i = 0;
        int j = 0;
        while (s.charAt(j) >= 'A' && s.charAt(j) <= 'Z') {
            j++;
        }
        int c1 = getCol(s.substring(0, j));
        int r1 = Integer.parseInt(s.substring(j, j + 1));
        j++;
        while (s.charAt(j) >= 'A' && s.charAt(j) <= 'Z') {
            j++;
        }
        int c2 = getCol(s.substring(j - 1, j));
        int r2 = Integer.parseInt(s.substring(j, j + 1));
        List<String> list = new ArrayList<>();
        for (int r = r1; r <= r2; r++) {
            for (int c = c1; c <= c2; c++) {
                list.add(getCol(c) + r);
            }
        }
        return list;
    }
    
    private int getCol(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = res * 26 + (s.charAt(i) - 'A' + 1);
        }
        return res;
    }
    
    private String getCol(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.insert(0, (char) (n % 26 + 'A'));
            n /= 26;
        }
        return sb.toString();
    }
}