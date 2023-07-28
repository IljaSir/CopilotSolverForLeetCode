impl Solution {
    pub fn maximum69_number (num: i32) -> i32 {
        
        let mut num_str = num.to_string();
        let mut changed = false;
        for i in 0..num_str.len() {
            if num_str.as_bytes()[i] == 54 && !changed {
                num_str.replace_range(i..i+1, "9");
                changed = true;
            }
        }
        num_str.parse::<i32>().unwrap()
    }
}