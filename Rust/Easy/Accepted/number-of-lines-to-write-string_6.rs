impl Solution {
    pub fn number_of_lines(widths: Vec<i32>, s: String) -> Vec<i32> {
        
        let mut lines = 1;
        let mut pixels = 0;
        for c in s.chars() {
            let width = widths[(c as u8 - 'a' as u8) as usize];
            if pixels + width > 100 {
                lines += 1;
                pixels = width;
            } else {
                pixels += width;
            }
        }
        vec![lines, pixels]
    }
}