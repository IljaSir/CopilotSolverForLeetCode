impl Solution {
    pub fn strong_password_checker_ii(password: String) -> bool {
        
        let mut count = 0;
        let mut isLower = false;
        let mut isUpper = false;
        let mut isDigit = false;
        let mut isSpecial = false;
        let mut isRepeat = false;
        for c in password.chars() {
            if c.is_lowercase() {
                isLower = true;
            }
            if c.is_uppercase() {
                isUpper = true;
            }
            if c.is_digit(10) {
                isDigit = true;
            }
            if c == '!' || c == '@' || c == '#' || c == '$' || c == '%' || c == '^' || c == '&' || c == '*' || c == '(' || c == ')' || c == '-' || c == '+' {
                isSpecial = true;
            }
        }
        let mut i = 0;
        let mut j = 0;
        while j < password.len() {
            if password.chars().nth(j).unwrap() == password.chars().nth(i).unwrap() {
                j += 1;
            } else {
                if j - i > 2 {
                    isRepeat = true;
                }
                i = j;
            }
        }
        if !isLower {
            count += 1;
        }
        if !isUpper {
            count += 1;
        }
        if !isDigit {
            count += 1;
        }
        if !isSpecial {
            count += 1;
        }
        if password.len() < 6 {
            if count == 0 {
                return true;
            } else {
                return password.len() + count >= 6;
            }
        }
        if password.len() > 20 {
            if isRepeat {
                return false;
            } else {
                return password.len() - count <= 20;
            }
        }
        if password.len() + count > 20 {
            return false;
        }
        return true;
    }
}