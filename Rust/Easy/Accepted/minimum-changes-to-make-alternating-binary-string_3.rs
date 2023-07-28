impl Solution {
    pub fn min_operations(s: String) -> i32 {
        
        let mut min = 0;
        for (i, c) in s.chars().enumerate() {
            if i % 2 == 0 {
                if c == '1' {
                    min += 1;
                }
            } else {
                if c == '0' {
                    min += 1;
                }
            }
        }
        min.min(s.len() as i32 - min)
    }
}