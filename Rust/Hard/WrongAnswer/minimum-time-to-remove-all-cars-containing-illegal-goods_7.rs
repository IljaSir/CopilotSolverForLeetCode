impl Solution {
    pub fn minimum_time(s: String) -> i32 {
        
        let mut count = 0;
        let mut res = 0;
        let mut last = 0;
        for c in s.chars() {
            if c == '1' {
                count += 1;
            } else {
                if count > 0 {
                    res += 2;
                    last = 2;
                } else {
                    last = 1;
                }
            }
        }
        if count > 0 {
            res - last + 1
        } else {
            0
        }
    }
}