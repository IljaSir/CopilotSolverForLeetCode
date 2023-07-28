impl Solution {
    pub fn are_numbers_ascending(s: String) -> bool {
        
        let mut last = 0;
        for t in s.split(' ') {
            if let Ok(n) = t.parse::<i32>() {
                if n <= last {
                    return false;
                }
                last = n;
            }
        }
        true
    }
}