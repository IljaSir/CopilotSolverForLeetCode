impl Solution {
    pub fn kth_grammar(n: i32, k: i32) -> i32 {
        
        let mut k = k;
        let mut res = 0;
        while k > 1 {
            if k % 2 == 0 {
                res ^= 1;
            }
            k = (k + 1) / 2;
        }
        res
    }
}