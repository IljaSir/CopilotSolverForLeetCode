impl Solution {
    pub fn thousand_separator(n: i32) -> String {
        
        let mut ret = String::new();
        let mut n = n;
        let mut i = 0;
        while n != 0 {
            if i % 3 == 0 && i != 0 {
                ret.push('.');
            }
            ret.push((n % 10 + '0' as i32) as u8 as char);
            n /= 10;
            i += 1;
        }
        ret.chars().rev().collect()
    }
}