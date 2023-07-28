impl Solution {
    pub fn convert_to_title(column_number: i32) -> String {
        
        let mut column_number = column_number;
        let mut res = Vec::new();
        while column_number > 0 {
            let n = column_number % 26;
            if n == 0 {
                res.push('Z');
                column_number = column_number / 26 - 1;
            } else {
                res.push((n as u8 + b'A' - 1) as char);
                column_number = column_number / 26;
            }
        }
        res.into_iter().rev().collect()
    }
}