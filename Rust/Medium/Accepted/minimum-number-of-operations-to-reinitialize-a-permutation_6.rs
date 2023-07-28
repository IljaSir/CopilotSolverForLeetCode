impl Solution {
    pub fn reinitialize_permutation(n: i32) -> i32 {
        
        let mut ans = 0;
        let mut i = 1;
        loop {
            ans += 1;
            i = if i % 2 == 0 { i / 2 } else { n / 2 + (i - 1) / 2 };
            if i == 1 {
                break;
            }
        }
        ans
    }
}