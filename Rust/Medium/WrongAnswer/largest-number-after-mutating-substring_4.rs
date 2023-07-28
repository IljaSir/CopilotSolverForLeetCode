impl Solution {
    pub fn maximum_number(num: String, change: Vec<i32>) -> String {
        
        let mut result = String::new();
        let mut is_changed = false;
        for c in num.chars() {
            let c = c.to_digit(10).unwrap() as usize;
            if change[c] > c as i32 {
                result.push_str(&change[c].to_string());
                is_changed = true;
            } else if change[c] < c as i32 {
                if is_changed {
                    break;
                } else {
                    result.push_str(&c.to_string());
                }
            } else {
                result.push_str(&c.to_string());
            }
        }
        result
    }
}