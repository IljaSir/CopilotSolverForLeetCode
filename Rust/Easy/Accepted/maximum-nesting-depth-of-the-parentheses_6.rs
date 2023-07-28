impl Solution {
    pub fn max_depth(s: String) -> i32 {
        
        let mut max = 0;
        let mut cur = 0;
        for c in s.chars() {
            match c {
                '(' => {
                    cur += 1;
                    if cur > max {
                        max = cur;
                    }
                }
                ')' => {
                    cur -= 1;
                }
                _ => {}
            }
        }
        max
    }
}