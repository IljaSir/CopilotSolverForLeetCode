impl Solution {
    pub fn kth_grammar(n: i32, k: i32) -> i32 {
        
        let mut k = k as usize;
        let mut n = n as usize;
        let mut res = 0;
        while n > 1 {
            let mid = 1 << (n - 2);
            if k > mid {
                res ^= 1;
                k -= mid;
            }
            n -= 1;
        }
        res
    }
}