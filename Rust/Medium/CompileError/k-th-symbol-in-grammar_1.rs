impl Solution {
    pub fn kth_grammar(n: i32, k: i32) -> i32 {
        
        if n == 1 {
            return 0;
        }
        let parent = Self::kth_grammar(n - 1, (k + 1) / 2);
        if parent == 0 {
            if k % 2 == 0 {
                return 1;
            } else {
                return 0;
            }
        } else {
            if k % 2 == 0 {
                return 0;
            } else {
                return 1;
            }
        }