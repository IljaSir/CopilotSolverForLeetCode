impl Solution {
    pub fn smallest_value(n: i32) -> i32 {
        
        let mut n = n;
        let mut ans = 0;
        while n > 1 {
            ans += 2;
            while n % ans == 0 {
                n /= ans;
            }
        }
        ans
    }
}