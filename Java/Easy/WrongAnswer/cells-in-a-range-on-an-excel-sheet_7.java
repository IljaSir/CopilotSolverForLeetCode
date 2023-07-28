class Solution {
    public List<String> cellsInRange(String s) {
        
        int[] range = parse(s);
        List<String> result = new ArrayList<>();
        for (int i = range[0]; i <= range[1]; i++) {
            for (int j = range[2]; j <= range[3]; j++) {
                result.add(convert(i, j));
            }
        }
        return result;
    }
    
    private int[] parse(String s) {
        int[] result = new int[4];
        String[] parts = s.split(":");
        int[] first = parseCell(parts[0]);
        int[] second = parseCell(parts[1]);
        result[0] = first[0];
        result[1] = second[0];
        result[2] = first[1];
        result[3] = second[1];
        return result;
    }
    
    private int[] parseCell(String s) {
        int[] result = new int[2];
        int i = 0;
        while (i < s.length() && Character.isAlphabetic(s.charAt(i))) {
            i++;
        }
        result[0] = Integer.parseInt(s.substring(i));
        result[1] = parseCol(s.substring(0, i));
        return result;
    }
    
    private int parseCol(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result = result * 26 + (s.charAt(i) - 'A' + 1);
        }
        return result;
    }
    
    private String convert(int row, int col) {
        String result = "";
        while (col > 0) {
            char c = (char) ((col - 1) % 26 + 'A');
            result = c + result;
            col = (col - 1) / 26;
        }
        result += row;
        return result;
    }
}