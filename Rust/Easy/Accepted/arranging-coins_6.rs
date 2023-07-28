impl Solution {
    pub fn arrange_coins(n: i32) -> i32 {
        
        let n = n as i64;
        let mut l = 0;
        let mut r = n + 1;
        while l < r {
            let mid = (l + r) / 2;
            if mid * (mid + 1) / 2 <= n {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        (l - 1) as i32
    }
}