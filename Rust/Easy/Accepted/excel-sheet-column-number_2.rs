impl Solution {
    pub fn title_to_number(column_title: String) -> i32 {
        
        let mut result = 0;
        for c in column_title.chars() {
            result *= 26;
            result += c as i32 - 'A' as i32 + 1;
        }
        result
    }
}