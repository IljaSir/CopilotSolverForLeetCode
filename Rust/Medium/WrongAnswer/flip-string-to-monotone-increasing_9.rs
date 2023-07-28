impl Solution {
    pub fn min_flips_mono_incr(s: String) -> i32 {
        
        let mut s = s.as_bytes();
        let mut count = 0;
        let mut count_0 = 0;
        for i in 0..s.len() {
            if s[i] == b'0' {
                count_0 += 1;
            } else {
                count += 1;
            }
            if count > count_0 {
                count = count_0;
            }
        }
        count
    }
}