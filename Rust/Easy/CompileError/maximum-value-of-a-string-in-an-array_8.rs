impl Solution {
    pub fn maximum_value(strs: Vec<String>) -> i32 {
        
        let mut max = 0;
        for s in strs {
            let mut is_digit = true;
            let mut count = 0;
            for c in s.chars() {
                if c.is_digit(10) {
                    count = count * 10 + c.to_digit(10).unwrap();
                } else {
                    is_digit = false;
                    count += 1;
                }
            }
            if is_digit {
                max = max.max(count);
            } else {
                max = max.max(count);
            }
        }
        max
    }
}