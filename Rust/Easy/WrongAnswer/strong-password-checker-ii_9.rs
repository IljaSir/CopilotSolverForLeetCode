impl Solution {
    pub fn strong_password_checker_ii(password: String) -> bool {
        
        let mut password = password.as_bytes();
        let mut n = password.len();
        let mut lower = false;
        let mut upper = false;
        let mut digit = false;
        let mut repeat = false;
        let mut i = 0;
        while i < n {
            if password[i].is_ascii_lowercase() {
                lower = true;
            } else if password[i].is_ascii_uppercase() {
                upper = true;
            } else if password[i].is_ascii_digit() {
                digit = true;
            }
            let mut j = i;
            while j < n && password[i] == password[j] {
                j += 1;
            }
            if j - i >= 3 {
                repeat = true;
            }
            i = j;
        }
        let mut missing = 0;
        if !lower {
            missing += 1;
        }
        if !upper {
            missing += 1;
        }
        if !digit {
            missing += 1;
        }
        if n < 6 {
            return missing + n >= 6;
        }
        if n <= 20 {
            return !repeat || missing == 0;
        }
        let mut delete = n - 20;
        i = 2;
        while i < n && delete > 0 {
            if password[i] == password[i - 1] && password[i] == password[i - 2] {
                let mut j = i + 1;
                while j < n && password[j] == password[i] {
                    j += 1;
                }
                let mut size = j - i;
                if size % 3 == 0 {
                    size -= 1;
                }
                delete -= size / 3;
                i = j;
            } else {
                i += 1;
            }
        }
        if delete == 0 {
            return !repeat || missing == 0;
        }
        let mut replace = 0;
        if repeat {
            replace = 1;
            delete -= 1;
        }
        replace += delete / 3;
        replace >= missing
    }
}