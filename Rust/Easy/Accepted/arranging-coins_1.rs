impl Solution {
    pub fn arrange_coins(n: i32) -> i32 {
        
        let n = n as i64;
        let mut left = 0;
        let mut right = n;
        while left <= right {
            let mid = left + (right - left) / 2;
            let sum = (1 + mid) * mid / 2;
            if sum == n {
                return mid as i32;
            } else if sum < n {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        right as i32
    }
}