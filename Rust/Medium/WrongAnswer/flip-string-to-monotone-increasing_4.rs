impl Solution {
    pub fn min_flips_mono_incr(s: String) -> i32 {
        
        let mut left = 0;
        let mut right = s.chars().filter(|&c| c == '1').count() as i32;
        let mut res = right;
        for c in s.chars() {
            if c == '1' {
                right -= 1;
            } else {
                left += 1;
            }
            res = res.min(left + right);
        }
        res
    }
}