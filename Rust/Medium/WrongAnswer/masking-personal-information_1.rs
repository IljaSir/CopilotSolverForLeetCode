impl Solution {
    pub fn mask_pii(s: String) -> String {
        
        if s.contains('@') {
            let mut chars = s.chars().collect::<Vec<_>>();
            for i in 1..chars.len() - 1 {
                if chars[i] != '@' {
                    chars[i] = '*';
                }
            }
            let mut res = String::new();
            for ch in chars {
                res.push(ch.to_ascii_lowercase());
            }
            res
        } else {
            let mut digits = s.chars()
                .filter(|ch| ch.is_ascii_digit())
                .collect::<Vec<_>>();
            let mut res = String::new();
            let len = digits.len();
            for i in 0..len {
                if i < len - 4 {
                    res.push('*');
                } else {
                    res.push(digits[i]);
                }
            }
            if len > 10 {
                let mut prefix = String::new();
                for i in 0..len - 10 {
                    prefix.push('+');
                }
                prefix.push('-');
                res = prefix + &res;
            }
            res.insert(0, '-');
            res.insert(0, '-');
            res.insert(0, '*');
            res.insert(0, '*');
            res.insert(0, '*');
            res
        }
    }
}