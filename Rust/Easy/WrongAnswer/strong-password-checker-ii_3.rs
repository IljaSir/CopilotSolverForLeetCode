impl Solution {
    pub fn strong_password_checker_ii(password: String) -> bool {
        
        let mut count = 0;
        let mut upper = false;
        let mut lower = false;
        let mut digit = false;
        let mut special = false;
        for c in password.chars() {
            if c.is_uppercase() {
                upper = true;
            } else if c.is_lowercase() {
                lower = true;
            } else if c.is_digit(10) {
                digit = true;
            } else if c == '!' || c == '@' || c == '#' || c == '$' || c == '%' || c == '^' || c == '&' || c == '*' || c == '(' || c == ')' || c == '-' || c == '+' {
                special = true;
            }
            count += 1;
        }
        return count >= 8 && upper && lower && digit && special;
    }
}