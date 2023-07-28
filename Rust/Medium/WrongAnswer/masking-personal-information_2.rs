impl Solution {
    pub fn mask_pii(s: String) -> String {
        
        if s.contains('@') {
            let mut chars = s.to_lowercase().chars().collect::<Vec<char>>();
            let mut i = 0;
            while chars[i] != '@' {
                if i > 0 && i < chars.len() - 1 {
                    chars[i] = '*';
                }
                i += 1;
            }
            chars.into_iter().collect::<String>()
        } else {
            let mut chars = s.chars().filter(|c| c.is_digit(10)).collect::<Vec<char>>();
            let mut mask = String::from("***-***-");
            mask.push_str(&chars[chars.len() - 4..].iter().collect::<String>());
            if chars.len() > 10 {
                let mut cc = String::new();
                for i in 0..chars.len() - 10 {
                    cc.push('*');
                }
                cc.push('-');
                mask = cc + &mask;
            }
            mask
        }
    }
}