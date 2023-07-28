impl Solution {
    pub fn strong_password_checker_ii(password: String) -> bool {
        
        let mut has_lower = false;
        let mut has_upper = false;
        let mut has_digit = false;
        let mut has_special = false;
        let mut same_count = 0;
        let mut same_char = '0';
        let mut same_count_max = 0;
        let mut same_count_max_count = 0;
        let mut same_count_max_count_max = 0;
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
            if c == same_char {
                same_count += 1;
            } else {
                if same_count > 2 {
                    same_count_max = std::cmp::max(same_count_max, same_count);
                    same_count_max_count = 1;
                    same_count_max_count_max = 1;
                } else if same_count == 2 {
                    same_count_max_count += 1;
                    same_count_max_count_max = std::cmp::max(same_count_max_count_max, same_count_max_count);
                }
                same_char = c;
                same_count = 1;
            }
        }
        if same_count > 2 {
            same_count_max = std::cmp::max(same_count_max, same_count);
            same_count_max_count = 1;
            same_count_max_count_max = 1;
        } else if same_count == 2 {
            same_count_max_count += 1;
            same_count_max_count_max = std::cmp::max(same_count_max_count_max, same_count_max_count);
        }
        let mut replace_count = 0;
        if !has_lower {
            replace_count += 1;
        }
        if !has_upper {
            replace_count += 1;
        }
        if !has_digit {
            replace_count += 1;
        }
        if !has_special {
            replace_count += 1;
        }
        if password.len() < 6 {
            replace_count = std
    }
}