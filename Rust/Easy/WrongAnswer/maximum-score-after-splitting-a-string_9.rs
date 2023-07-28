impl Solution {
    pub fn max_score(s: String) -> i32 {
        
        let mut count = 0;
        let mut max = 0;
        let mut l = 0;
        let mut r = 0;
        let mut i = 0;
        for c in s.chars() {
            if c == '0' {
                l += 1;
            } else {
                r += 1;
            }
            if i == s.len() - 1 {
                break;
            }
            if l == r {
                count += 1;
                if count > max {
                    max = count;
                }
            }
            i += 1;
        }
        max
    }
}