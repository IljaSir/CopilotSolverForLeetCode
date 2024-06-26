class Solution {
    public boolean strongPasswordCheckerII(String password) {
        
        return password.length() >= 8 && password.matches(".*[a-z].*") && password.matches(".*[A-Z].*") && password.matches(".*[0-9].*") && password.matches(".*[!@#$%^&*()-+].*") && !password.matches("(.)\\1{2,}");
    }
}