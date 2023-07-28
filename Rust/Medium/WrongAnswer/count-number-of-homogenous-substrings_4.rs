impl Solution {
    pub fn count_homogenous(s: String) -> i32 {
        
        let mut count = 0;
        let mut last = ' ';
        let mut streak = 0;
        for c in s.chars() {
            if c != last {
                last = c;
                streak = 0;
            }
            streak += 1;
            count += streak;
        }
        (count % 1_000_000_007) as i32
    }
}