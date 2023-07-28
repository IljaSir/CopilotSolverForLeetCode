impl Solution {
    pub fn to_hex(num: i32) -> String {
        
        let mut n = num;
        if n == 0 {
            return "0".to_string();
        }
        let mut res = String::new();
        let mut count = 0;
        while n != 0 && count < 8 {
            let r = n & 0xf;
            if r < 10 {
                res.insert(0, (r + '0' as i32) as u8 as char);
            } else {
                res.insert(0, (r - 10 + 'a' as i32) as u8 as char);
            }
            n = n >> 4;
            count += 1;
        }
        res
    }
}