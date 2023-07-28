class Solution {
    public boolean isNumber(String s) {
        
        try {
            double d = Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}