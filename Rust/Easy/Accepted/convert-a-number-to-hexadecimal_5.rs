impl Solution {
    pub fn to_hex(num: i32) -> String {
        
        let mut result = String::new();
        let mut n = num;
        if n == 0 {
            return "0".to_string();
        }
        for _ in 0..8 {
            let mut t = n & 0xf;
            if t < 10 {
                t += 48;
            } else {
                t += 87;
            }
            result.insert(0, t as u8 as char);
            n >>= 4;
        }
        result.trim_start_matches('0').to_string()
    }
}