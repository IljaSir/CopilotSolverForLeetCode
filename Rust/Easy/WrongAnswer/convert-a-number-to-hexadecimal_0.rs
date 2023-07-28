impl Solution {
    pub fn to_hex(num: i32) -> String {
        
        if num == 0 {
            return "0".to_string();
        }
        let mut result = String::new();
        let mut n = num;
        let mut i = 0;
        while n != 0 && i < 8 {
            let last = n & 0xf;
            if last < 10 {
                result.push_str(&(last + 48).to_string());
            } else {
                result.push_str(&(last + 87).to_string());
            }
            n >>= 4;
            i += 1;
        }
        result.chars().rev().collect()
    }
}