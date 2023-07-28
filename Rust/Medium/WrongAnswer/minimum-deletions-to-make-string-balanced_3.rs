impl Solution {
    pub fn minimum_deletions(s: String) -> i32 {
        
        let mut b = 0;
        let mut res = 0;
        for c in s.chars() {
            if c == 'a' {
                if b > 0 {
                    b -= 1;
                } else {
                    res += 1;
                }
            } else {
                b += 1;
            }
        }
        res
    }
}