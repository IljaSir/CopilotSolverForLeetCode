impl Solution {
    pub fn min_operations(s: String) -> i32 {
        
        let mut c1 = 0;
        let mut c2 = 0;
        let mut i = 0;
        for c in s.chars() {
            if (i % 2 == 0 && c == '1') || (i % 2 == 1 && c == '0') {
                c1 += 1;
            } else {
                c2 += 1;
            }
            i += 1;
        }
        std::cmp::min(c1, c2)
    }
}