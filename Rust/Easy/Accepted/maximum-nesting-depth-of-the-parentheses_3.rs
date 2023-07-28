impl Solution {
    pub fn max_depth(s: String) -> i32 {
        
        let mut max = 0;
        let mut count = 0;
        for c in s.chars() {
            match c {
                '(' => {
                    count += 1;
                    if count > max {
                        max = count;
                    }
                }
                ')' => {
                    count -= 1;
                }
                _ => {}
            }
        }
        max
    }
}