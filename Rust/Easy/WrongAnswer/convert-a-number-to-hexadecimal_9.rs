impl Solution {
    pub fn to_hex(num: i32) -> String {
        
        let mut n = num;
        if n < 0 {
            n += 2_i32.pow(32);
        }
        let mut res = String::new();
        let mut mask = 0b1111;
        while n > 0 {
            let cur = n & mask;
            if cur < 10 {
                res.push((cur as u8 + '0' as u8) as char);
            } else {
                res.push((cur as u8 - 10 + 'a' as u8) as char);
            }
            n >>= 4;
        }
        if res.is_empty() {
            res.push('0');
        }
        res.chars().rev().collect()
    }
}