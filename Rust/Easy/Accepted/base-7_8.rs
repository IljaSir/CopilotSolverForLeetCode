impl Solution {
    pub fn convert_to_base7(num: i32) -> String {
        
        let mut result = String::new();
        let mut num = num;
        let mut is_negative = false;
        if num < 0 {
            is_negative = true;
            num = -num;
        }

        let mut digits = Vec::new();
        while num > 0 {
            digits.push(num % 7);
            num = num / 7;
        }

        if digits.len() == 0 {
            digits.push(0);
        }

        if is_negative {
            result.push('-');
        }

        for i in (0..digits.len()).rev() {
            result.push((digits[i] as u8 + b'0') as char);
        }

        result
    }
}