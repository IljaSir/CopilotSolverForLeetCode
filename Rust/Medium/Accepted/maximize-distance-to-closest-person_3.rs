impl Solution {
    pub fn max_dist_to_closest(seats: Vec<i32>) -> i32 {
        
        let mut left = -1;
        let mut right = 0;
        let mut max = 0;
        let n = seats.len();
        for i in 0..n {
            if seats[i] == 1 {
                left = i as i32;
            } else {
                while right < n as i32 && seats[right as usize] == 0 || right < i as i32 {
                    right += 1;
                }
                let left_dist = if left == -1 { n as i32 } else { i as i32 - left };
                let right_dist = if right == n as i32 { n as i32 } else { right - i as i32 };
                max = max.max(left_dist.min(right_dist));
            }
        }
        max
    }
}