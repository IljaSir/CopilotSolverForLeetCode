impl Solution {
    pub fn number_of_lines(widths: Vec<i32>, s: String) -> Vec<i32> {
        
        let mut line = 1;
        let mut width = 0;
        for c in s.chars() {
            let w = widths[(c as usize) - 97];
            if width + w > 100 {
                line += 1;
                width = w;
            } else {
                width += w;
            }
        }
        vec![line, width]
    }
}