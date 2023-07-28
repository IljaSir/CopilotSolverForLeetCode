impl Solution {
    pub fn thousand_separator(n: i32) -> String {
        
        let mut result = String::from("");
        let mut n = n;
        let mut count = 0;
        while n > 0 {
            if count == 3 {
                result.push('.');
                count = 0;
            }
            result.push((n % 10 + '0' as i32) as u8 as char);
            n /= 10;
            count += 1;
        }
        if result.len() == 0 {
            return "0".to_string();
        }
        result.chars().rev().collect::<String>()
    }
}