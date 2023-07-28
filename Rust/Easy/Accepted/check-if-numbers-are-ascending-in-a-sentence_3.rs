impl Solution {
    pub fn are_numbers_ascending(s: String) -> bool {
        
        let mut prev = 0;
        for w in s.split_whitespace() {
            if let Ok(n) = w.parse::<i32>() {
                if n > prev {
                    prev = n;
                } else {
                    return false;
                }
            }
        }
        true
    }
}