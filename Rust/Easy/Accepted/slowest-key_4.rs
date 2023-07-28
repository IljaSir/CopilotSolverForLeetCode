impl Solution {
    pub fn slowest_key(release_times: Vec<i32>, keys_pressed: String) -> char {
        
        let mut max = release_times[0];
        let mut max_key = keys_pressed.chars().nth(0).unwrap();
        for i in 1..release_times.len() {
            let t = release_times[i] - release_times[i - 1];
            if t > max || (t == max && keys_pressed.chars().nth(i).unwrap() > max_key) {
                max = t;
                max_key = keys_pressed.chars().nth(i).unwrap();
            }
        }
        max_key
    }
}