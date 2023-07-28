impl Solution {
    pub fn convert_to_title(column_number: i32) -> String {
        
        let mut result = String::new();
        let mut column_number = column_number;
        while column_number > 0 {
            column_number -= 1;
            result.push((b'A' + (column_number % 26) as u8) as char);
            column_number /= 26;
        }
        result.chars().rev().collect()
    }
}