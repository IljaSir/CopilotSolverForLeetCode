impl Solution {
    pub fn strong_password_checker_ii(password: String) -> bool {
        
        let mut has_lower = false;
        let mut has_upper = false;
        let mut has_digit = false;
        let mut has_special = false;
        let mut repeat_count = 0;
        let mut repeat_char = ' ';
        let mut repeat_len = 0;
        let mut repeat_max = 0;
        for c in password.chars() {
            if c.is_lowercase() {
                has_lower = true;
            } else if c.is_uppercase() {
                has_upper = true;
            } else if c.is_digit(10) {
                has_digit = true;
            } else if c == '!' || c == '@' || c == '#' || c == '$' || c == '%' || c == '^' || c == '&' || c == '*' || c == '(' || c == ')' || c == '-' || c == '+' {
                has_special = true;
            }
            if c == repeat_char {
                repeat_len += 1;
            } else {
                repeat_char = c;
                repeat_count = 1;
                repeat_len = 1;
            }
            repeat_max = repeat_max.max(repeat_len);
        }
        let mut change_count = 0;
        if !has_lower {
            change_count += 1;
        }
        if !has_upper {
            change_count += 1;
        }
        if !has_digit {
            change_count += 1;
        }
        if !has_special {
            change_count += 1;
        }
        let mut delete_count = 0;
        if password.len() < 6 {
            delete_count = 6 - password.len();
            change_count = change_count.max(delete_count);
        } else if password.len() > 20 {
            delete_count = password.len() - 20;
            change_count += delete_count;
        }
        change_count <= repeat_max
    }
}