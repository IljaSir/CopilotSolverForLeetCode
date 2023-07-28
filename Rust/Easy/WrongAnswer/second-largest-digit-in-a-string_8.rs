impl Solution {
    pub fn second_highest(s: String) -> i32 {
        
        let mut max = 0;
        let mut second_max = 0;
        for c in s.chars() {
            if c.is_digit(10) {
                let n = c.to_digit(10).unwrap();
                if n > max {
                    second_max = max;
                    max = n;
                } else if n > second_max && n < max {
                    second_max = n;
                }
            }
        }
        if second_max == 0 {
            -1
        } else {
            second_max as i32
        }
    }
}