impl Solution {
    pub fn min_flips_mono_incr(s: String) -> i32 {
        
        let mut c = 0;
        let mut flip = 0;
        for i in s.chars() {
            if i == '0' {
                c += 1;
            } else {
                flip += 1;
            }
            if flip < c {
                c -= 1;
                flip += 1;
            }
        }
        flip
    }
}