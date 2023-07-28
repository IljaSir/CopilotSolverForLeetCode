impl Solution {
    pub fn min_flips_mono_incr(s: String) -> i32 {
        
        let mut zeros = 0;
        let mut ones = 0;
        for c in s.chars() {
            if c == '0' {
                zeros += 1;
            } else {
                ones += 1;
            }
            if zeros < ones {
                zeros = ones;
            }
        }
        (zeros - ones) as i32
    }
}