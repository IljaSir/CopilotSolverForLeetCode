impl Solution {
    pub fn modify_string(s: String) -> String {
        
        let mut s = s.chars().collect::<Vec<char>>();
        for i in 0..s.len() {
            if s[i] == '?' {
                for c in b'a'..=b'z' {
                    if i > 0 && s[i - 1] as u8 == c {
                        continue;
                    }
                    if i + 1 < s.len() && s[i + 1] as u8 == c {
                        continue;
                    }
                    s[i] = c as char;
                    break;
                }
            }
        }
        s.into_iter().collect()
    }
}