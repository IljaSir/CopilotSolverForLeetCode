impl Solution {
    pub fn min_flips_mono_incr(s: String) -> i32 {
        
        let mut count = 0;
        let mut zero_count = 0;
        for c in s.chars() {
            if c == '0' {
                zero_count += 1;
            } else {
                if zero_count > 0 {
                    zero_count -= 1;
                    count += 1;
                }
            }
        }
        count
    }
}