impl Solution {
    pub fn convert_to_base7(num: i32) -> String {
        
        if num == 0 {
            return "0".to_string();
        }
        let mut num = num;
        let mut result = String::new();
        let mut negative = false;
        if num < 0 {
            negative = true;
            num = -num;
        }
        while num > 0 {
            let digit = num % 7;
            num /= 7;
            result.push((digit as u8 + b'0') as char);
        }
        if negative {
            result.push('-');
        }
        result.chars().rev().collect()
    }
}