impl Solution {
    pub fn convert_to_title(column_number: i32) -> String {
        
        let mut s = String::new();
        let mut n = column_number;
        while n > 0 {
            n -= 1;
            let c = ('A' as u8 + (n % 26) as u8) as char;
            s.push(c);
            n /= 26;
        }
        s.chars().rev().collect()
    }
}