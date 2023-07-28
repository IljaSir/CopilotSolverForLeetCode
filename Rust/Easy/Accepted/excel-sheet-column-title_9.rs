impl Solution {
    pub fn convert_to_title(column_number: i32) -> String {
        
        let mut column_number = column_number;
        let mut result = String::new();
        while column_number > 0 {
            let remainder = column_number % 26;
            let ch = if remainder == 0 { 'Z' } else { (remainder - 1 + 'A' as i32) as u8 as char };
            result.insert(0, ch);
            column_number = (column_number - 1) / 26;
        }
        result
    }
}