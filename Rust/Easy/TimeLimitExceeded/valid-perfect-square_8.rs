impl Solution {
    pub fn is_perfect_square(num: i32) -> bool {
        
        let mut l = 1;
        let mut r = num;
        while l <= r {
            let mid = (l + r) / 2;
            let sq = mid * mid;
            if sq == num {
                return true;
            } else if sq > num {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        false
    }
}