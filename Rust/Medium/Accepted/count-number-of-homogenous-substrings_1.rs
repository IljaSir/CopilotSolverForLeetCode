impl Solution {
    pub fn count_homogenous(s: String) -> i32 {
        
        let mut count = 0;
        let mut prev = '\0';
        let mut streak = 0;
        for c in s.chars() {
            if c == prev {
                streak += 1;
            } else {
                prev = c;
                streak = 1;
            }
            count += streak;
            count %= 1_000_000_007;
        }
        count as i32
    }
}