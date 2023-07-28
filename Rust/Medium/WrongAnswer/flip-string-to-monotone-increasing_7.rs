impl Solution {
    pub fn min_flips_mono_incr(s: String) -> i32 {
        
        let mut zero = 0;
        let mut one = 0;
        for c in s.chars(){
            if c == '0' {
                zero += 1;
            } else {
                one += 1;
                if zero > 0 {
                    zero -= 1;
                    one -= 1;
                }
            }
        }
        one
    }
}