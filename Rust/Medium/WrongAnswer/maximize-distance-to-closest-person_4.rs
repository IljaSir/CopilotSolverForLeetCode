impl Solution {
    pub fn max_dist_to_closest(seats: Vec<i32>) -> i32 {
        
        let mut max = 0;
        let mut i = 0;
        let mut j = 0;
        while i < seats.len() {
            if seats[i] == 1 {
                if j == 0 {
                    max = i;
                } else {
                    max = std::cmp::max(max, (i - j) / 2);
                }
                j = i + 1;
            }
            i += 1;
        }
        if j < seats.len() {
            max = std::cmp::max(max, seats.len() - j);
        }
        max as i32
    }
}