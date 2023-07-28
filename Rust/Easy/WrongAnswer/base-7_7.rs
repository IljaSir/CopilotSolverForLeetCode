impl Solution {
    pub fn convert_to_base7(num: i32) -> String {
        
        let mut result = String::new();
        let mut num = num;
        let mut is_minus = false;
        if num < 0 {
            is_minus = true;
            num = -num;
        }
        while num > 0 {
            result.push_str(&format!("{}", num % 7));
            num /= 7;
        }
        if is_minus {
            result.push('-');
        }
        result.chars().rev().collect()
    }
}