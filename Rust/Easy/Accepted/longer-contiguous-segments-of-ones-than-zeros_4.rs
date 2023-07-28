impl Solution {
    pub fn check_zero_ones(s: String) -> bool {
        
        let mut max_ones = 0;
        let mut max_zeros = 0;
        let mut count_ones = 0;
        let mut count_zeros = 0;
        for c in s.chars() {
            if c == '0' {
                count_zeros += 1;
                count_ones = 0;
            } else {
                count_ones += 1;
                count_zeros = 0;
            }
            max_ones = max_ones.max(count_ones);
            max_zeros = max_zeros.max(count_zeros);
        }
        max_ones > max_zeros
    }
}