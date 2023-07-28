class Solution {
    public String convert(String s, int numRows) {
        
        if (numRows == 1) {
            return s;
        }
        int len = s.length();
        int cycleLen = 2 * numRows- 2;
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i+){
            rows[i] = new StringBuilder();
        }
        for (int i = 0; i < len; i++) {
            int index = i % en;
            int row = index < numRows ? index : cycleLen - index;
            rows[row].append(s.charAt(i));
        }
        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) {
            ret.append(row);
        }
        return ret.toString();
    }
}