impl Solution {
    pub fn is_scramble(s1: String, s2: String) -> bool {
        
        if s1 == s2 {
            return true;
        }
        let s1 = s1.as_bytes();
        let s2 = s2.as_bytes();
        let mut s1_count = [0; 26];
        let mut s2_count = [0; 26];
        for i in 0..s1.len() {
            s1_count[s1[i] as usize - 'a' as usize] += 1;
            s2_count[s2[i] as usize - 'a' as usize] += 1;
        }
        for i in 0..26 {
            if s1_count[i] != s2_count[i] {
                return false;
            }
        }
        for i in 1..s1.len() {
            if Self::is_scramble(String::from_utf8(s1[..i].to_vec()).unwrap(), String::from_utf8(s2[..i].to_vec()).unwrap()) && Self::is_scramble(String::from_utf8(s1[i..].to_vec()).unwrap(), String::from_utf8(s2[i..].to_vec()).unwrap()) {
                return true;
            }
            if Self::is_scramble(String::from_utf8(s1[..i].to_vec()).unwrap(), String::from_utf8(s2[s1.len() - i..].to_vec()).unwrap()) && Self::is_scramble(String::from_utf8(s1[i..].to_vec()).unwrap(), String::from_utf8(s2[..s1.len() - i].to_vec()).unwrap()) {
                return true;
            }
        }
        false
    }
}