impl Solution {
    pub fn min_flips_mono_incr(s: String) -> i32 {
        
        let mut zero_count = 0;
        let mut one_count = 0;
        for c in s.chars() {
            if c == '0' {
                zero_count += 1;
            } else {
                one_count += 1;
            }
        }
        
        let mut zero_count = zero_count;
        let mut one_count = 0;
        let mut result = zero_count;
        for c in s.chars() {
            if c == '0' {
                zero_count -= 1;
            } else {
                one_count += 1;
            }
            result = std::cmp::min(result, zero_count + one_count);
        }
        result
    }
}