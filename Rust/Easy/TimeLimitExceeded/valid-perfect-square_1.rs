impl Solution {
    pub fn is_perfect_square(num: i32) -> bool {
        
        let mut left = 1;
        let mut right = num;
        while left <= right {
            let mid = left + (right - left) / 2;
            if mid * mid == num {
                return true;
            } else if mid * mid < num {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        false
    }
}