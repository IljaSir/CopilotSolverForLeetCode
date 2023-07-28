impl Solution {
    pub fn slowest_key(release_times: Vec<i32>, keys_pressed: String) -> char {
        
        let mut max_time = release_times[0];
        let mut max_key = keys_pressed.chars().nth(0).unwrap();
        for i in 1..release_times.len() {
            let time = release_times[i] - release_times[i-1];
            if time > max_time {
                max_time = time;
                max_key = keys_pressed.chars().nth(i).unwrap();
            } else if time == max_time {
                max_key = max_key.max(keys_pressed.chars().nth(i).unwrap());
            }
        }
        max_key
    }
}