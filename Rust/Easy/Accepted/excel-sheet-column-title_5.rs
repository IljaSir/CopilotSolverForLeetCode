impl Solution {
    pub fn convert_to_title(column_number: i32) -> String {
        
        let mut column_number = column_number;
        let mut s = String::new();
        while column_number > 0 {
            column_number -= 1;
            let c = (column_number % 26) as u8 + 'A' as u8;
            s.push(c as char);
            column_number /= 26;
        }
        s.chars().rev().collect()
    }
}