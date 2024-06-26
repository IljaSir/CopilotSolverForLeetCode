impl Solution {
    pub fn repeated_substring_pattern(s: String) -> bool {
        
        let s = s.as_bytes();
        let n = s.len();
        for i in 1..=n/2 {
            if n % i == 0 {
                let mut ok = true;
                for j in i..n {
                    if s[j] != s[j-i] {
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