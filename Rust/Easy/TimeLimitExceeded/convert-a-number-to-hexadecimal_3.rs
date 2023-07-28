impl Solution {
    pub fn to_hex(num: i32) -> String {
        
        let mut num = num;
        let mut hex = String::new();
        if num == 0 {
            return "0".to_string();
        }
        while num != 0 {
            let digit = num & 0xf;
            let c = match digit {
                0..=9 => (digit + '0' as i32) as u8 as char,
                10..=15 => (digit - 10 + 'a' as i32) as u8 as char,
                _ => panic!("invalid digit: {}", digit),
            };
            hex.push(c);
            num >>= 4;
        }
        hex.chars().rev().collect()
    }
}