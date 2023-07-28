impl Solution {
    pub fn count_homogenous(s: String) -> i32 {
        
        let mut count = 0;
        let mut prev = ' ';
        let mut prev_count = 0;
        for c in s.chars() {
            if c == prev {
                prev_count += 1;
            } else {
                prev = c;
                prev_count = 1;
            }
            count = (count + prev_count) % 1000000007;
        }
        count
    }
}