impl Solution {
    pub fn repeated_substring_pattern(s: String) -> bool {
        
        let s = s.as_bytes();
        let len = s.len();
        for i in 1..=len / 2 {
            if len % i == 0 {
                let mut ok = true;
                for j in i..len {
                    if s[j] != s[j % i] {
                        ok = false;
                        break;
                    }
                }
                if ok {
                    return true;
                }
            }
        }
        false
    }
}