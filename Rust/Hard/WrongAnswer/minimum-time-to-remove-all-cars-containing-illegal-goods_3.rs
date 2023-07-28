impl Solution {
    pub fn minimum_time(s: String) -> i32 {
        
        let mut res = 0;
        let mut count = 0;
        for c in s.chars() {
            if c == '0' {
                count = 0;
            } else {
                count += 1;
                if count % 2 == 1 {
                    res += 2;
                }
            }
        }
        res - if count % 2 == 1 { 1 } else { 0 }
    }
}