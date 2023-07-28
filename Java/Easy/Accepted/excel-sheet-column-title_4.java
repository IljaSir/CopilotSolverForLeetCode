class Solution {
    public String convertToTitle(int columnNumber) {
        
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            char ch = (char) ((columnNumber - 1) % 26 + 'A');
            sb.append(ch);
            columnNumber = (columnNumber - 1) / 26;
        }
        return sb.reverse().toString();
    }
}