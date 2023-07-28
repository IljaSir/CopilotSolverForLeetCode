class Solution {
    public List<String> cellsInRange(String s) {
        
        String[] parts = s.split(":");
        String a = parts[0];
        String b = parts[1];
        int c1 = a.charAt(0) - 'A';
        int r1 = Integer.parseInt(a.substring(1));
        int c2 = b.charAt(0) - 'A';
        int r2 = Integer.parseInt(b.substring(1));
        List<String> res = new ArrayList<>();
        for (int i = c1; i <= c2; i++) {
            for (int j = r1; j <= r2; j++) {
                res.add((char)('A' + i) + "" + j);
            }
        }
        return res;
    }
}