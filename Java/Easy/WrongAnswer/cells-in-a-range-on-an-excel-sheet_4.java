class Solution {
    public List<String> cellsInRange(String s) {
        
        String[] parts = s.split(":");
        int[] start = parse(parts[0]);
        int[] end = parse(parts[1]);
        List<String> res = new ArrayList<>();
        for (int i = start[0]; i <= end[0]; i++) {
            for (int j = start[1]; j <= end[1]; j++) {
                res.add(encode(i, j));
            }
        }
        return res;
    }
    
    int[] parse(String s) {
        int[] res = new int[2];
        int i = 0;
        while (i < s.length() && Character.isLetter(s.charAt(i))) i++;
        res[0] = Integer.parseInt(s.substring(i));
        res[1] = decode(s.substring(0, i));
        return res;
    }
    
    String encode(int row, int col) {
        return encode(col) + row;
    }
    
    String encode(int col) {
        StringBuilder sb = new StringBuilder();
        while (col > 0) {
            sb.append((char)('A' + (col - 1) % 26));
            col = (col - 1) / 26;
        }
        return sb.reverse().toString();
    }
    
    int decode(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = res * 26 + (s.charAt(i) - 'A' + 1);
        }
        return res;
    }
}