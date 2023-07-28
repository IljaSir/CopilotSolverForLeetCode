impl Solution {
    pub fn repeated_substring_pattern(s: String) -> bool {
        
        let s = s.as_bytes();
        let n = s.len();
        let mut i = 1;
        while i <= n / 2 {
            if n % i == 0 {
                let mut j = i;
                while j < n {
                    if s[j] != s[j % i] {
                        break;
                    }
                    j += 1;
                }
                if j == n {
                    return true;
                }
            }
            i += 1;
        }
        false
    }
}