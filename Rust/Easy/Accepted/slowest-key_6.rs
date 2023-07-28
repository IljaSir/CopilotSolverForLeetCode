impl Solution {
    pub fn slowest_key(release_times: Vec<i32>, keys_pressed: String) -> char {
        
        let mut max = release_times[0];
        let mut res = keys_pressed.chars().next().unwrap();
        for i in 1..release_times.len() {
            let diff = release_times[i] - release_times[i-1];
            if diff > max {
                max = diff;
                res = keys_pressed.chars().nth(i).unwrap();
            } else if diff == max {
                let c = keys_pressed.chars().nth(i).unwrap();
                if c > res {
                    res = c;
                }
            }
        }
        res
    }
}