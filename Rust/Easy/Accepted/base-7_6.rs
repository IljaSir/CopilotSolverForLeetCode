impl Solution {
    pub fn convert_to_base7(num: i32) -> String {
        
        let mut n = num;
        let mut s = String::new();
        let mut is_neg = false;
        if n < 0 {
            n = -n;
            is_neg = true;
        }
        loop {
            s.push((n % 7 + '0' as i32) as u8 as char);
            n /= 7;
            if n == 0 {
                break;
            }
        }
        if is_neg {
            s.push('-');
        }
        s.chars().rev().collect()
    }
}