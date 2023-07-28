impl Solution {
    pub fn title_to_number(column_title: String) -> i32 {
        
        let mut n = 0;
        for c in column_title.chars() {
            n = n * 26 + (c as i32 - 'A' as i32 + 1);
        }
        n
    }
}