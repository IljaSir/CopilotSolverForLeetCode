impl Solution {
    pub fn min_operations(s: String) -> i32 {
        
        let mut c1 = 0;
        let mut c2 = 0;
        let mut i = 0;
        for c in s.chars() {
            if i % 2 == 0 {
                if c == '0' {
                    c1 += 1;
                } else {
                    c2 += 1;
                }
            } else {
                if c == '0' {
                    c2 += 1;
                } else {
                    c1 += 1;
                }
            }
            i += 1;
        }
        c1.min(c2)
    }
}