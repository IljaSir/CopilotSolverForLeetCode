impl Solution {
    pub fn slowest_key(release_times: Vec<i32>, keys_pressed: String) -> char {
        
        let mut max = release_times[0];
        let mut max_c = keys_pressed.chars().nth(0).unwrap();
        for i in 1..release_times.len() {
            let duration = release_times[i] - release_times[i - 1];
            if duration > max {
                max = duration;
                max_c = keys_pressed.chars().nth(i).unwrap();
            } else if duration == max {
                max_c = max_c.max(keys_pressed.chars().nth(i).unwrap());
            }
        }
        max_c
    }
}