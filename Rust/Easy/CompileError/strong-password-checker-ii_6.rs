impl Solution {
    pub fn strong_password_checker_ii(password: String) -> bool {
        
        let mut has_lower = false;
        let mut has_upper = false;
        let mut has_digit = false;
        let mut has_special = false;
        let mut has_repeated = false;
        let mut repeated_count = 1;
        let mut prev = ' ';
        for c in password.chars() {
            match c {
                'a'..='z' => has_lower = true,
                'A'..='Z' => has_upper = true,
                '0'..='9' => has_digit = true,
                '!'|'@'|'#'|'$'|'%'|'^'|'&'|'*'|'('|')'|'-'|'+' => has_special = true,
                _ => (),
            }
            if c == prev {
                repeated_count += 1;
            } else {
                repeated_count = 1;
            }
            if repeated_count >= 3 {
                has_repeated = true;
            }
            prev = c;
        }
        let mut missing = 0;
        if !has_lower { missing += 1; }
        if !has_upper { missing += 1; }
        if !has_digit { missing += 1; }
        if !has_special { missing += 1; }
        if password.len() < 8 {
            if password.len() + missing >= 8 {
                return true;
            } else {
                return false;
            }
        }
        let mut count = 0;
        if has_repeated {
            count += 1;
        }
        if has_lower {
            count += 1;
        }
        if has_upper {
            count += 1;
        }
        if has_digit {
            count += 1;
        }
        if has_special {
            count += 1;
        }
        if count == 3 && missing == 1 && password.len() == 8 {
            return true;
        }
        if count == 4 && missing == 0 && password.len() == 8 {
            return true;
        }
        if count == 4 && missing == 1 && password.len() == 9 {
            return true;
        }
        if count == 5 && missing == 0 && password.len() == 9 {
            return true;
        }
        if count == 5 && missing == 1 && password.len() == 10 {
            return true;
        }
        if count ==
    }
}