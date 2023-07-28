impl Solution {
    pub fn longest_nice_substring(s: String) -> String {
        
        let s = s.as_bytes();
        let mut i = 0;
        let mut j = s.len()-1;
        let mut res = String::new();
        while i < j {
            if s[i].is_ascii_uppercase() && s[j].is_ascii_lowercase() {
                if s[i].to_ascii_lowercase() == s[j] {
                    let left = Self::longest_nice_substring(String::from_utf8(s[i+1..j].to_vec()).unwrap());
                    let right = Self::longest_nice_substring(String::from_utf8(s[i+1..j].to_vec()).unwrap());
                    if left.len() > res.len() {
                        res = left;
                    }
                    if right.len() > res.len() {
                        res = right;
                    }
                    i = j;
                } else {
                    j -= 1;
                }
            } else {
                i += 1;
            }
        }
        res
    }
}