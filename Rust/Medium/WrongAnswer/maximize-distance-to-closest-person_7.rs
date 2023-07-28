impl Solution {
    pub fn max_dist_to_closest(seats: Vec<i32>) -> i32 {
        
        let mut l = 0;
        let mut r = 0;
        let mut max = 0;
        let mut last = 0;
        for i in 0..seats.len() {
            if seats[i] == 1 {
                if l == 0 {
                    max = i as i32;
                } else {
                    max = std::cmp::max(max, (r - l) / 2);
                }
                l = i as i32;
            }
            r = i as i32 + 1;
        }
        max = std::cmp::max(max, seats.len() as i32 - 1 - l);
        max
    }
}