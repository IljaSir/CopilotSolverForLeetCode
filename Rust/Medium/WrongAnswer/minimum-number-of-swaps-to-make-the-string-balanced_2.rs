impl Solution {
    pub fn min_swaps(s: String) -> i32 {
        
        let mut res = 0;
        let mut count = 0;
        for c in s.chars() {
            if c == '[' {
                count += 1;
            } else {
                if count == 0 {
                    res += 1;
                } else {
                    count -= 1;
                }
            }
        }
        res
    }
}