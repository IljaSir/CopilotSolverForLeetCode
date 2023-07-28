impl Solution {
    pub fn max_dist_to_closest(seats: Vec<i32>) -> i32 {
        
        let mut max = 0;
        let mut last = -1;
        for i in 0..seats.len() {
            if seats[i] == 1 {
                if last < 0 {
                    max = i as i32;
                } else {
                    max = max.max((i - last as usize) as i32 / 2);
                }
                last = i as i32;
            }
        }
        max.max(seats.len() as i32 - last - 1)
    }
}