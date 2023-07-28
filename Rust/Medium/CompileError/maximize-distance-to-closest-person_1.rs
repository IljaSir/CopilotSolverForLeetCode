impl Solution {
    pub fn max_dist_to_closest(seats: Vec<i32>) -> i32 {
        
        let mut left = -1;
        let mut right = 0;
        let mut max = 0;
        for i in 0..seats.len() {
            if seats[i] == 1 {
                left = i as i32;
            } else {
                while right < seats.len() as i32 && (right == 0 || seats[right as usize] == 0) {
                    right += 1;
                }
                let left_dist = if left == -1 { i32::max_value() } else { i - left as usize };
                let right_dist = if right == seats.len() as i32 { i32::max_value() } else { right - i as i32 };
                max = max.max(left_dist.min(right_dist));
            }
        }
        max
    }
}