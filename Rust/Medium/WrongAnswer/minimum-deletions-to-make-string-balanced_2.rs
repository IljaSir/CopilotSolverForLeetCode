impl Solution {
    pub fn minimum_deletions(s: String) -> i32 {
        
        let mut res = 0;
        let mut a = 0;
        for c in s.chars() {
            if c == 'a' {
                a += 1;
            } else {
                if a > 0 {
                    a -= 1;
                } else {
                    res += 1;
                }
            }
        }
        res
    }
}