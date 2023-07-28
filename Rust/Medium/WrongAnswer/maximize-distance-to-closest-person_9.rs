impl Solution {
    pub fn max_dist_to_closest(seats: Vec<i32>) -> i32 {
        
        let mut max = 0;
        let mut left = 0;
        let mut right = 0;
        let mut first = true;
        for seat in seats {
            if seat == 0 {
                right += 1;
            } else {
                if first {
                    max = right;
                    first = false;
                } else {
                    max = max.max((right - left) / 2);
                }
                left = right;
                right = 0;
            }
        }
        max = max.max(right);
        max as i32
    }
}