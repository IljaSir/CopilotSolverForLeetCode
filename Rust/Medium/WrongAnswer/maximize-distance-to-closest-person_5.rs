impl Solution {
    pub fn max_dist_to_closest(seats: Vec<i32>) -> i32 {
        
        let mut max = 0;
        let mut start = 0;
        let mut end = 0;
        let mut flag = false;
        for i in 0..seats.len() {
            if seats[i] == 1 {
                if flag {
                    let d = (end - start + 1) / 2;
                    if d > max {
                        max = d;
                    }
                } else {
                    let d = end - start;
                    if d > max {
                        max = d;
                    }
                    flag = true;
                }
                start = i as i32;
            }
            end = i as i32;
        }
        let d = end - start;
        if d > max {
            max = d;
        }
        max as i32
    }
}