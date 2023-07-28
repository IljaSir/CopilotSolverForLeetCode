impl Solution {
    pub fn max_power(s: String) -> i32 {
        
        let mut max = 0;
        let mut count = 1;
        let mut prev = s.chars().next().unwrap();
        for c in s.chars().skip(1) {
            if c == prev {
                count += 1;
            } else {
                if count > max {
                    max = count;
                }
                count = 1;
            }
            prev = c;
        }
        if count > max {
            max = count;
        }
        max
    }
}