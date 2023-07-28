impl Solution {
    pub fn min_operations(s: String) -> i32 {
        
        let mut s0 = 0;
        let mut s1 = 0;
        let mut s0c = 0;
        let mut s1c = 0;
        let mut s0c1 = 0;
        let mut s1c1 = 0;
        for (i, c) in s.chars().enumerate() {
            if i % 2 == 0 {
                if c == '0' {
                    s0c += 1;
                } else {
                    s1c += 1;
                }
            } else {
                if c == '0' {
                    s0c1 += 1;
                } else {
                    s1c1 += 1;
                }
            }
        }
        s0 = s0c + s1c1;
        s1 = s0c1 + s1c;
        s0.min(s1)
    }
}