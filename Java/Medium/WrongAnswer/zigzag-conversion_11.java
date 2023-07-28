class Solution {
    public String convert(String s, int numRows) {
        
        if (numRows == 1) {
            return s;
        }
        int len = s.length();
        char[] chars = s.toCharArray();
        char[] result = new char[len];
        int index = 0;
        int numCols = len / (2 * numRows - 2) * (numRows - 1);
        if (len % (2 * numRows - 2) != 0) {
            numCols += Math.min(len % (2 * numRows - 2), numRows);
        }
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (i == 0 || i == numRows - 1) {
                    if (2 * numRows - 2 * i - 2 + 2 * numRows * j < len) {
                        result[index] = chars[2 * numRows - 2 * i - 2 + 2 * numRows * j];
                        index++;
                    }
                } else {
                    if (2 * numRows - 2 * i - 2 + 2 * numRows * j < len) {
                        result[index] = chars[2 * numRows - 2 * i - 2 + 2 * numRows * j];
                        index++;
                    }
                    if (2 * i + 2 * numRows * j < len) {
                        result[index] = chars[2 * i + 2 * numRows * j];
                        index++;
                    }
                }
            }
        }
        return String.valueOf(result);
    }
}