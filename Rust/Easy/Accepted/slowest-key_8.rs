impl Solution {
    pub fn slowest_key(release_times: Vec<i32>, keys_pressed: String) -> char {
        
        let mut max = release_times[0];
        let mut res = keys_pressed.chars().nth(0).unwrap();
        for (i, c) in keys_pressed.chars().enumerate().skip(1) {
            let duration = release_times[i] - release_times[i - 1];
            if duration > max || (duration == max && c > res) {
                max = duration;
                res = c;
            }
        }
        res
    }
}