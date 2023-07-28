impl Solution {
    pub fn min_insertions(s: String) -> i32 {
        
        let mut ans = 0;
        let mut open = 0;
        let mut close = 0;
        for c in s.chars() {
            if c == '(' {
                open += 1;
                if close % 2 == 1 {
                    close -= 1;
                    open += 1;
                    ans += 1;
                }
            } else {
                close += 1;
                if close == 2 {
                    close = 0;
                    if open > 0 {
                        open -= 1;
                    } else {
                        ans += 1;
                    }
                }
            }
        }
        ans + open * 2 + close
    }
}