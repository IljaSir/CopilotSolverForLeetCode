impl Solution {
    pub fn min_swaps(s: String) -> i32 {
        
        let mut count = 0;
        let mut open = 0;
        for c in s.chars() {
            if c == '[' {
                open += 1;
            } else {
                if open == 0 {
                    count += 1;
                } else {
                    open -= 1;
                }
            }
        }
        count
    }
}