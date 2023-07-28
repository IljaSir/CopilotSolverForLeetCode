impl Solution {
    pub fn minimum_length(s: String) -> i32 {
        
        let mut s = s.as_bytes();
        let mut l = 0;
        let mut r = s.len() - 1;
        while l < r {
            if s[l] != s[r] {
                break;
            }
            let c = s[l];
            while l <= r && s[l] == c {
                l += 1;
            }
            while l <= r && s[r] == c {
                r -= 1;
            }
        }
        (r - l + 1) as i32
    }
}