impl Solution {
    pub fn max_power(s: String) -> i32 {
        
        let mut max = 1;
        let mut count = 1;
        let mut last = s.chars().nth(0).unwrap();
        for c in s.chars().skip(1) {
            if c == last {
                count += 1;
                if count > max {
                    max = count;
                }
            } else {
                count = 1;
                last = c;
            }
        }
        max
    }
}