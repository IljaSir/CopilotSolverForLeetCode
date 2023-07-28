class Solution {
    public boolean isValid(String code) {
        
        return code.matches("<([A-Z]{1,9})>[^<]*</\\1>");
    }
}