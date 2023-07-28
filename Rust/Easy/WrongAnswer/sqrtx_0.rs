impl Solution {
    pub fn my_sqrt(x: i32) -> i32 {
        
        let mut left = 0;
        let mut right = x;
        let mut ans = -1;
        while left <= right {
            let mid = left + (right - left) / 2;
            if mid * mid <= x {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        ans
    }
}