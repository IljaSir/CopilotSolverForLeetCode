impl Solution {
    pub fn make_strings_equal(s: String, target: String) -> bool {
        
        let mut s = s.chars().collect::<Vec<char>>();
        let mut target = target.chars().collect::<Vec<char>>();
        let mut n = s.len();
        let mut i = 0;
        while i < n {
            if s[i] != target[i] {
                if i == n - 1 {
                    return false;
                }
                s[i] = (s[i] as u8 ^ s[i+1] as u8) as char;
                s[i+1] = (s[i+1] as u8 ^ s[i] as u8) as char;
                s[i] = (s[i] as u8 ^ s[i+1] as u8) as char;
                if s[i] != target[i] {
                    return false;
                }
                n -= 1;
            } else {
                i += 1;
            }
        }
        true
    }
}