impl Solution {
    pub fn max_power(s: String) -> i32 {
        
        let mut max = 1;
        let mut count = 1;
        let mut chars = s.chars();
        let mut prev = chars.next();
        for c in chars {
            if c == prev.unwrap() {
                count += 1;
                if count > max {
                    max = count;
                }
            } else {
                count = 1;
            }
            prev = Some(c);
        }
        max
    }
}