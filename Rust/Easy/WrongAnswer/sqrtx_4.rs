impl Solution {
    pub fn my_sqrt(x: i32) -> i32 {
        
        if x == 0 {
            return 0;
        }
        let mut left = 1;
        let mut right = x;
        while left < right {
            let mid = (left + right) / 2;
            if mid > x / mid {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        left - 1
    }
}