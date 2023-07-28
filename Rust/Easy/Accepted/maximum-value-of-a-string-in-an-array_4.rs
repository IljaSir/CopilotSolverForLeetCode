impl Solution {
    pub fn maximum_value(strs: Vec<String>) -> i32 {
        
        let mut max = 0;
        for s in strs {
            let mut is_digit = true;
            for c in s.chars() {
                if !c.is_digit(10) {
                    is_digit = false;
                    break;
                }
            }
            if is_digit {
                max = max.max(s.parse::<i32>().unwrap());
            } else {
                max = max.max(s.len() as i32);
            }
        }
        max
    }
}