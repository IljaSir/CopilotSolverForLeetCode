impl Solution {
    pub fn to_hex(num: i32) -> String {
        
        let mut result = String::new();
        let mut n = num;
        if n == 0 {
            return "0".to_string();
        }
        
        for _ in 0..8 {
            let last_digit = n & 15;
            if last_digit < 10 {
                result.push((last_digit + 48) as u8 as char);
            } else {
                result.push((last_digit + 87) as u8 as char);
            }
            n >>= 4;
        }
        
        result.chars().rev().collect()
    }
}