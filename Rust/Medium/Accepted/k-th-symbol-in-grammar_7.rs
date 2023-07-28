impl Solution {
    pub fn kth_grammar(n: i32, k: i32) -> i32 {
        
        if n == 1 {
            return 0;
        }
        let k = k - 1;
        let n = n - 1;
        let mid = 1 << (n - 1);
        if k < mid {
            return Self::kth_grammar(n, k + 1);
        }
        if Self::kth_grammar(n, k - mid + 1) == 0 {
            return 1;
        }
        0
    }
}