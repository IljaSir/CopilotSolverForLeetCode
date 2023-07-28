impl Solution {
    pub fn my_sqrt(x: i32) -> i32 {
        
        if x == 0 {
            return 0;
        }
        let mut l = 1;
        let mut r = x;
        while l < r {
            let mid = l + (r - l) / 2;
            if mid > x / mid {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        l - 1
    }
}