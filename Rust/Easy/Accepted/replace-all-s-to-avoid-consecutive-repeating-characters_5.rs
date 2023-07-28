impl Solution {
    pub fn modify_string(s: String) -> String {
        
        let mut s = s.chars().collect::<Vec<char>>();
        for i in 0..s.len() {
            if s[i] == '?' {
                for c in 0..=25 {
                    if (i == 0 || (i > 0 && (s[i-1] as u8 - 'a' as u8) as u8 != c)) && (i == s.len()-1 || (i < s.len()-1 && (s[i+1] as u8 - 'a' as u8) as u8 != c)) {
                        s[i] = (c as u8 + 'a' as u8) as char;
                        break;
                    }
                }
            }
        }
        s.iter().collect::<String>()
    }
}