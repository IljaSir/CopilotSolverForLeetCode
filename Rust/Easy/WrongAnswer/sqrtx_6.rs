impl Solution {
    pub fn my_sqrt(x: i32) -> i32 {
        
        let mut left = 0;
        let mut right = x;
        let mut mid = 0;
        while left <= right {
            mid = left + (right - left) / 2;
            if mid * mid == x {
                return mid;
            } else if mid * mid < x {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        right
    }
}