impl Solution {
    pub fn title_to_number(column_title: String) -> i32 {
        
        let mut result = 0;
        let mut base = 1;
        for c in column_title.chars().rev() {
            result += (c as u8 - b'A' + 1) as i32 * base;
            base *= 26;
        }
        result
    }
}