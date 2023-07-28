impl Solution {
    pub fn min_flips_mono_incr(s: String) -> i32 {
        
        let mut count = 0;
        let mut zero = 0;
        let mut one = 0;
        for c in s.chars() {
            if c == '0' {
                zero += 1;
            } else {
                one += 1;
            }
            count = count.min(zero - one);
        }
        count + one
    }
}