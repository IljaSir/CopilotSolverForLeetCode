impl Solution {
    pub fn max_dist_to_closest(seats: Vec<i32>) -> i32 {
        
        let mut max = 0;
        let mut i = 0;
        let mut j = 0;
        let mut count = 0;
        while j < seats.len() {
            if seats[j] == 1 {
                if i == 0 {
                    if max < j {
                        max = j;
                    }
                } else {
                    if max < (j - i - 1) / 2 {
                        max = (j - i - 1) / 2;
                    }
                }
                i = j;
            }
            j += 1;
        }
        if max < seats.len() - i - 1 {
            max = seats.len() - i - 1;
        }
        max as i32
    }
}