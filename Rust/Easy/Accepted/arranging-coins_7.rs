impl Solution {
    pub fn arrange_coins(n: i32) -> i32 {
        
        let n = n as i64;
        let mut l = 0;
        let mut r = n;
        while l <= r {
            let mid = (l + r) / 2;
            let sum = mid * (mid + 1) / 2;
            if sum == n {
                return mid as i32;
            } else if sum < n {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        r as i32
    }
}