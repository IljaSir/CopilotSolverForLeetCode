impl Solution {
    pub fn max_power(s: String) -> i32 {
        
        let mut max = 1;
        let mut current = 1;
        let mut chars = s.chars();
        let mut prev = chars.next();
        for c in chars {
            if prev == Some(c) {
                current += 1;
                if current > max {
                    max = current;
                }
            } else {
                current = 1;
            }
            prev = Some(c);
        }
        max
    }
}