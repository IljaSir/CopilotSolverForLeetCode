impl Solution {
    pub fn kth_grammar(n: i32, k: i32) -> i32 {
        
        if n == 1 {
            return 0;
        }
        let mid = 1 << (n-2);
        if k <= mid {
            return Self::kth_grammar(n-1, k);
        } else {
            return 1 - Self::kth_grammar(n-1, k-mid);
        }
    }
}