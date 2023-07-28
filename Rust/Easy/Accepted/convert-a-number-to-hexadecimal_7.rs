impl Solution {
    pub fn to_hex(num: i32) -> String {
        
        let mut n = num as u32;
        if n == 0 { return "0".to_string(); }
        let mut result = String::new();
        for _ in 0..8 {
            let mut digit = (n & 0xf) as u8;
            if digit < 10 {
                digit += b'0';
            } else {
                digit += b'a' - 10;
            }
            result.push(digit as char);
            n >>= 4;
        }
        result.chars().rev().collect::<String>().trim_start_matches('0').to_string()
    }
}