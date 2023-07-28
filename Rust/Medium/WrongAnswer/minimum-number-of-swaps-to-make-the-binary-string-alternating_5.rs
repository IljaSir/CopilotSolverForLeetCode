impl Solution {
    pub fn min_swaps(s: String) -> i32 {
        
        let mut c0 = 0;
        let mut c1 = 0;
        for (i, ch) in s.chars().enumerate() {
            if (i % 2 == 0) != (ch == '0') {
                c0 += 1;
            }
            if (i % 2 == 0) != (ch == '1') {
                c1 += 1;
            }
        }
        if c0 % 2 == 0 && c1 % 2 == 0 {
            return std::cmp::min(c0, c1) / 2;
        }
        -1
    }
}