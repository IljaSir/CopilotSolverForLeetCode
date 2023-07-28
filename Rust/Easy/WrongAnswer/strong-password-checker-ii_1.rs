impl Solution {
    pub fn strong_password_checker_ii(password: String) -> bool {
        
        let mut count = 0;
        let mut has_lower = false;
        let mut has_upper = false;
        let mut has_digit = false;
        let mut has_special = false;
        for c in password.chars() {
            if c.is_lowercase() {
                has_lower = true;
            } else if c.is_uppercase() {
                has_upper = true;
            } else if c.is_digit(10) {
                has_digit = true;
            } else if !c.is_alphanumeric() {
                has_special = true;
            }
        }
        if !has_lower {
            count += 1;
        }
        if !has_upper {
            count += 1;
        }
        if !has_digit {
            count += 1;
        }
        if !has_special {
            count += 1;
        }
        let len = password.len();
        if len < 6 {
            let need = 6 - len;
            if need <= count {
                count = need;
            } else {
                count += (need - count) / 2;
            }
        } else if len > 20 {
            let need = len - 20;
            if need <= count {
                count = need;
            } else {
                count += (need - count) / 2;
            }
        }
        count == 0
    }
}