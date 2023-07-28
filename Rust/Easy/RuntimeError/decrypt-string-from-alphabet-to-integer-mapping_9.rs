impl Solution {
    pub fn freq_alphabets(s: String) -> String {
        
        let mut res = String::new();
        let mut i = s.len() - 1;
        while i > 0 {
            if s.as_bytes()[i] == '#' as u8 {
                res.push(((s[i - 2..i].parse::<u8>().unwrap() - 1) % 26 + 'a' as u8) as char);
                i -= 3;
            } else {
                res.push(((s[i..i + 1].parse::<u8>().unwrap() - 1) % 26 + 'a' as u8) as char);
                i -= 1;
            }
        }
        if i == 0 {
            res.push(((s[i..i + 1].parse::<u8>().unwrap() - 1) % 26 + 'a' as u8) as char);
        }
        res.chars().rev().collect()
    }
}