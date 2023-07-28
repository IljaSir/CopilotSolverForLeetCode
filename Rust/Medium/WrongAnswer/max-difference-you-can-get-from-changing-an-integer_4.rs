impl Solution {
    pub fn max_diff(num: i32) -> i32 {
        
        let num_str = num.to_string();
        let mut max = num_str.clone();
        let mut min = num_str.clone();
        let mut first = true;
        for c in num_str.chars() {
            if c == '9' {
                continue;
            }
            if first {
                max = max.replace(&c.to_string(), "9");
                first = false;
            }
            if c == '1' || c == '0' {
                continue;
            }
            min = min.replace(&c.to_string(), "1");
        }
        max.parse::<i32>().unwrap() - min.parse::<i32>().unwrap()
    }
}