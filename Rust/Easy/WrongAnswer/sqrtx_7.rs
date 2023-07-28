impl Solution {
    pub fn my_sqrt(x: i32) -> i32 {
        
        if x == 0 {
            return 0;
        }
        let mut left = 1;
        let mut right = x;
        let mut mid = 0;
        while left <= right {
            mid = (left + right) / 2;
            let t = mid as i64 * mid as i64;
            if t == x as i64 {
                return mid;
            } else if t > x as i64 {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if mid as i64 * mid as i64 > x as i64 {
            mid - 1
        } else {
            mid
        }
    }
}