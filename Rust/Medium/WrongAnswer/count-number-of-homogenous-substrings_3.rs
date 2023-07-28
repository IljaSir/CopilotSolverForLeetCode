impl Solution {
    pub fn count_homogenous(s: String) -> i32 {
        
        let mut count = 0;
        let mut last = ' ';
        let mut last_count = 0;
        for c in s.chars() {
            if c != last {
                last = c;
                last_count = 1;
            } else {
                last_count += 1;
            }
            count += last_count;
        }
        count as i32 % 1_000_000_007
    }
}