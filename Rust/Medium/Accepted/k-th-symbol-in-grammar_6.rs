impl Solution {
    pub fn kth_grammar(n: i32, k: i32) -> i32 {
        
        let mut k = k;
        let mut res = 0;
        for _ in 0..n-1 {
            if k % 2 == 0 {
                res = 1 - res;
            }
            k = (k + 1) / 2;
        }
        res
    }
}