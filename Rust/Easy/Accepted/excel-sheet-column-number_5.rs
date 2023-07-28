impl Solution {
    pub fn title_to_number(column_title: String) -> i32 {
        
        let mut num = 0;
        for c in column_title.chars() {
            num = num * 26 + (c as u8 - b'A' + 1) as i32;
        }
        num
    }
}