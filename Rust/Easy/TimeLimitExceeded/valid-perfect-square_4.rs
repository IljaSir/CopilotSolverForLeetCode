impl Solution {
    pub fn is_perfect_square(num: i32) -> bool {
        
        let mut l = 1;
        let mut r = num;
        while l <= r {
            let m = l + (r - l) / 2;
            if m * m == num {
                return true;
            } else if m * m < num {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        false
    }
}