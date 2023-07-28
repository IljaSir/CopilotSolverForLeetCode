impl Solution {
    pub fn kth_grammar(n: i32, k: i32) -> i32 {
        
        let mut k = k - 1;
        let mut ans = 0;
        for i in 0..n {
            ans ^= (k >> i) & 1;
        }
        ans
    }
}