impl Solution {
    pub fn number_of_lines(widths: Vec<i32>, s: String) -> Vec<i32> {
        
        let mut cnt = 0;
        let mut lines = 1;
        for c in s.chars() {
            let w = widths[c as usize - 'a' as usize];
            if cnt + w > 100 {
                lines += 1;
                cnt = w;
            } else {
                cnt += w;
            }
        }
        vec![lines, cnt]
    }
}