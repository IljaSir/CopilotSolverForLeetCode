impl Solution {
    pub fn check_zero_ones(s: String) -> bool {
        
        let mut max_1 = 0;
        let mut max_0 = 0;
        let mut curr_1 = 0;
        let mut curr_0 = 0;
        for c in s.chars() {
            if c == '1' {
                curr_1 += 1;
                max_1 = max_1.max(curr_1);
                curr_0 = 0;
            } else {
                curr_0 += 1;
                max_0 = max_0.max(curr_0);
                curr_1 = 0;
            }
        }
        max_1 > max_0
    }
}