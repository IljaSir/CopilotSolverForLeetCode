impl Solution {
    pub fn check_zero_ones(s: String) -> bool {
        
        let mut max_ones = 0;
        let mut max_zeros = 0;
        let mut count = 0;
        let mut prev = ' ';
        for c in s.chars() {
            if c != prev {
                count = 1;
                prev = c;
            } else {
                count += 1;
            }
            if c == '1' {
                max_ones = max_ones.max(count);
            } else {
                max_zeros = max_zeros.max(count);
            }
        }
        max_ones > max_zeros
    }
}