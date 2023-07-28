impl Solution {
    pub fn mask_pii(s: String) -> String {
        
        if s.contains('@') {
            let mut chars = s.chars();
            let c1 = chars.next().unwrap().to_ascii_lowercase();
            let mut c2 = String::new();
            for c in chars {
                if c == '@' {
                    break;
                }
                if c != '.' {
                    c2.push('*');
                }
            }
            let c3 = chars.collect::<String>();
            format!("{}{}@{}", c1, c2, c3.to_ascii_lowercase())
        } else {
            let mut chars = s.chars().filter(|c| c.is_digit(10));
            let mut code = String::new();
            let mut local = String::new();
            let mut count = 0;
            for c in chars {
                count += 1;
                if count <= 10 {
                    local.push(c);
                } else {
                    code.push(c);
                }
            }
            let mut result = String::new();
            if code.len() > 0 {
                result.push('+');
                for _ in 0..code.len() {
                    result.push('*');
                }
                result.push('-');
            }
            result.push_str("***-***-");
            result.push_str(&local[6..]);
            result
        }
    }
}