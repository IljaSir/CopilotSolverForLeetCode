impl Solution {
    pub fn number_of_lines(widths: Vec<i32>, s: String) -> Vec<i32> {
        
        let mut line = 1;
        let mut width = 0;
        for c in s.chars() {
            let w = widths[(c as u8 - 'a' as u8) as usize];
            if width + w <= 100 {
                width += w;
            } else {
                line += 1;
                width = w;
            }
        }
        vec![line, width]
    }
}