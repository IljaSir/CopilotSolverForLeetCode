impl Solution {
    pub fn strong_password_checker_ii(password: String) -> bool {
        
        let mut has_lower = false;
        let mut has_upper = false;
        let mut has_digit = false;
        let mut has_special = false;
        let mut has_repeated = false;
        let mut repeated_count = 0;
        let mut repeated_char = ' ';
        let mut repeated_count_max = 0;
        for (i, c) in password.chars().enumerate() {
            if c.is_alphabetic() {
                if c.is_lowercase() {
                    has_lower = true;
                } else {
                    has_upper = true;
                }
            } else if c.is_digit(10) {
                has_digit = true;
            } else {
                has_special = true;
            }
            if c == repeated_char {
                repeated_count += 1;
            } else {
                repeated_count = 1;
                repeated_char = c;
            }
            if repeated_count == 3 {
                has_repeated = true;
                if i + 1 < password.len() && password.chars().nth(i + 1).unwrap() == repeated_char {
                    repeated_count_max = 2;
                } else {
                    repeated_count_max = 1;
                }
            }
        }
        let mut missing = 0;
        if !has_lower {
            missing += 1;
        }
        if !has_upper {
            missing += 1;
        }
        if !has_digit {
            missing += 1;
        }
        if !has_special {
            missing += 1;
        }
        let mut replace = 0;
        if password.len() < 6 {
            replace = 6 - password.len();
        } else if password.len() > 20 {
            replace = password.len() - 20;
        }
        if replace > 0 {
            if replace <= missing {
                missing -= replace;
                replace = 0;
            } else {
                replace -= missing;
                missing = 0;
            }
            if replace > 0 {
                if replace >= repeated_count_max {
                    replace -= repeated_count_max;
                    repeated_count_max = 0;
                } else {
                    repeated_count_max -= replace;
                    replace = 0;
                }
                if replace > 0 {
                    if replace >= repeated_count_max {
                        replace -= repeated_count_max;
                        repeated_count_max = 0;
                    } else {
                        repeated_count_max -= replace;
                        replace = 0;
                    }
                }