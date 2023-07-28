impl Solution {
    pub fn kth_grammar(n: i32, k: i32) -> i32 {
        
        let mut k = k - 1;
        let mut ans = 0;
        while k > 0 {
            ans += k & 1;
            k >>= 1;
        }
        ans & 1
    }
}