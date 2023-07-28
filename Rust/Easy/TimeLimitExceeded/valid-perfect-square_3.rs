impl Solution {
    pub fn is_perfect_square(num: i32) -> bool {
        
        let mut left = 0;
        let mut right = num;
        while left <= right {
            let mid = left + (right - left) / 2;
            let square = mid * mid;
            if square == num {
                return true;
            } else if square < num {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        false
    }
}