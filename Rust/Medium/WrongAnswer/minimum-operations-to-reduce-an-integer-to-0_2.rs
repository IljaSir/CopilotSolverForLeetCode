impl Solution {
    pub fn min_operations(n: i32) -> i32 {
        
        let mut ans = 0;
        for i in 1..n {
            if i % 2 == 1 {
                ans += n - i;
            }
        }
        ans
    }
}