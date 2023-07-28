impl Solution {
    pub fn arrange_coins(n: i32) -> i32 {
        
        let n = n as i64;
        let mut l = 0;
        let mut r = n;
        while l < r {
            let m = l + (r - l + 1) / 2;
            if m * (m + 1) / 2 <= n {
                l = m;
            } else {
                r = m - 1;
            }
        }
        l as i32
    }
}