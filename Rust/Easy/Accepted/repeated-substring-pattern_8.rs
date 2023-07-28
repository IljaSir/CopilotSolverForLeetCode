impl Solution {
    pub fn repeated_substring_pattern(s: String) -> bool {
        
        for i in 1..s.len() {
            if s.len() % i == 0 {
                let mut ok = true;
                for j in 0..s.len() {
                    if s.as_bytes()[j] != s.as_bytes()[j % i] {
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