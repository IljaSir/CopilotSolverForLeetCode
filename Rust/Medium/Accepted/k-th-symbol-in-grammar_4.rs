impl Solution {
    pub fn kth_grammar(n: i32, k: i32) -> i32 {
        
        if n == 1 {
            return 0;
        }
        if k % 2 == 0 {
            return 1 - Solution::kth_grammar(n-1, k/2);
        }
        Solution::kth_grammar(n-1, (k+1)/2)
    }
}