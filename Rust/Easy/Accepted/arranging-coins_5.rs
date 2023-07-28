impl Solution {
    pub fn arrange_coins(n: i32) -> i32 {
        
        let n = n as u64;
        let mut left = 0;
        let mut right = n;
        while left <= right {
            let mid = left + (right - left) / 2;
            if mid * (mid + 1) / 2 == n {
                return mid as i32;
            } else if mid * (mid + 1) / 2 < n {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        right as i32
    }
}