impl Solution {
    pub fn title_to_number(column_title: String) -> i32 {
        
        let mut ans = 0;
        let mut factor = 1;
        for c in column_title.chars().rev() {
            ans += (c as i32 - 'A' as i32 + 1) * factor;
            factor *= 26;
        }
        ans
    }
}