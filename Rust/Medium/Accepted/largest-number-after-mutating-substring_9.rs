impl Solution {
    pub fn maximum_number(num: String, change: Vec<i32>) -> String {
        
        let mut result = String::new();
        let mut i = 0;
        let mut is_changed = false;
        while i < num.len() {
            let c = num[i..i+1].parse::<i32>().unwrap();
            if c < change[c as usize] {
                result.push_str(&change[c as usize].to_string());
                is_changed = true;
            } else if c > change[c as usize] {
                if is_changed {
                    result.push_str(&num[i..]);
                    break;
                } else {
                    result.push_str(&c.to_string());
                }
            } else {
                result.push_str(&c.to_string());
            }
            i += 1;
        }
        result
    }
}