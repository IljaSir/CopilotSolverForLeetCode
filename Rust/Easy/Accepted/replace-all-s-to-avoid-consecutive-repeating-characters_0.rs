impl Solution {
    pub fn modify_string(s: String) -> String {
        
        let mut s = s.chars().collect::<Vec<char>>();
        for i in 0..s.len() {
            if s[i] == '?' {
                for c in b'a'..=b'z' {
                    if (i == 0 || s[i - 1] != c as char) && (i == s.len() - 1 || s[i + 1] != c as char) {
                        s[i] = c as char;
                        break;
                    }
                }
            }
        }
        s.into_iter().collect::<String>()
    }
}