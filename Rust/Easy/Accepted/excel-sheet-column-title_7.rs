impl Solution {
    pub fn convert_to_title(column_number: i32) -> String {
        
        let mut res = String::new();
        let mut n = column_number;
        while n > 0 {
            let c = (n - 1) % 26;
            n = (n - 1) / 26;
            res.push((c + 65) as u8 as char);
        }
        res.chars().rev().collect()
    }
}