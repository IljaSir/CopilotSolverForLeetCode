impl Solution {
    pub fn max_power(s: String) -> i32 {
        
        let mut max = 0;
        let mut curr = 1;
        for i in 1..s.len() {
            if s.as_bytes()[i] == s.as_bytes()[i - 1] {
                curr += 1;
            } else {
                if curr > max {
                    max = curr;
                }
                curr = 1;
            }
        }
        if curr > max {
            max = curr;
        }
        max
    }
}