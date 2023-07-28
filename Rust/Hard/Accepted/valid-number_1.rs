impl Solution {
    pub fn is_number(s: String) -> bool {
        
        let s = s.trim();
        let mut is_number = false;
        let mut is_exp = false;
        let mut is_dot = false;
        for (i, c) in s.chars().enumerate() {
            match c {
                '+' | '-' => {
                    if i > 0 && s.chars().nth(i - 1).unwrap() != 'e' && s.chars().nth(i - 1).unwrap() != 'E' {
                        return false;
                    }
                },
                '0'..='9' => {
                    is_number = true;
                },
                '.' => {
                    if is_dot || is_exp {
                        return false;
                    }
                    is_dot = true;
                },
                'e' | 'E' => {
                    if is_exp || !is_number {
                        return false;
                    }
                    is_exp = true;
                    is_number = false;
                },
                _ => return false,
            }
        }
        is_number
    }
}