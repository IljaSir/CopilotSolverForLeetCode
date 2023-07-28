impl Solution {
    pub fn check_zero_ones(s: String) -> bool {
        
        let mut max_one = 0;
        let mut max_zero = 0;
        let mut counter_one = 0;
        let mut counter_zero = 0;
        for c in s.chars() {
            if c == '1' {
                counter_one += 1;
                counter_zero = 0;
            } else {
                counter_zero += 1;
                counter_one = 0;
            }
            max_one = std::cmp::max(max_one, counter_one);
            max_zero = std::cmp::max(max_zero, counter_zero);
        }
        max_one > max_zero
    }
}