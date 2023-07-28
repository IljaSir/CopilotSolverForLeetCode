impl Solution {
    pub fn maximum_value(strs: Vec<String>) -> i32 {
        
        let mut max = 0;
        for s in strs {
            let mut sum = 0;
            for c in s.chars() {
                if let Some(d) = c.to_digit(10) {
                    sum = sum * 10 + d;
                } else {
                    sum += 1;
                }
            }
            if sum > max {
                max = sum;
            }
        }
        max as i32
    }
}