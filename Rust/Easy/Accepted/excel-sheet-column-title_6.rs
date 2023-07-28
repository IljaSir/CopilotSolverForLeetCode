impl Solution {
    pub fn convert_to_title(column_number: i32) -> String {
        
        let mut res = String::new();
        let mut num = column_number;
        while num > 0 {
            num -= 1;
            let c = (num % 26) as u8 + b'A';
            res.push(c as char);
            num /= 26;
        }
        res.chars().rev().collect()
    }
}