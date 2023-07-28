impl Solution {
    pub fn max_dist_to_closest(seats: Vec<i32>) -> i32 {
        
        let mut d = 0;
        let mut max = 0;
        let mut left = 0;
        let mut right = 0;
        for i in 0..seats.len() {
            if seats[i] == 1 {
                right = i;
                if left == 0 {
                    d = right;
                } else {
                    d = (right - left) / 2;
                }
                max = std::cmp::max(max, d);
                left = right;
            }
        }
        if seats[seats.len() - 1] == 0 {
            max = std::cmp::max(max, seats.len() - 1 - right);
        }
        max as i32
    }
}