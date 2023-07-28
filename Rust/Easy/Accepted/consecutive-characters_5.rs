impl Solution {
    pub fn max_power(s: String) -> i32 {
        
        let mut max = 0;
        let mut count = 1;
        let mut last = ' ';
        for c in s.chars() {
            if c == last {
                count += 1;
            } else {
                if count > max {
                    max = count;
                }
                last = c;
                count = 1;
            }
        }
        if count > max {
            max = count;
        }
        max
    }
}