impl Solution {
    pub fn minimum_deletions(s: String) -> i32 {
        
        let mut count = 0;
        let mut res = 0;
        for c in s.chars() {
            if c == 'b' {
                count += 1;
            } else {
                if count > 0 {
                    count -= 1;
                    res += 1;
                }
            }
        }
        res
    }
}