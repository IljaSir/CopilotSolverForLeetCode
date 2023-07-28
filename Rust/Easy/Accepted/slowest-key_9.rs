impl Solution {
    pub fn slowest_key(release_times: Vec<i32>, keys_pressed: String) -> char {
        
        let mut max = 0;
        let mut max_c = ' ';
        for i in 0..release_times.len() {
            let t = if i == 0 { release_times[i] } else { release_times[i] - release_times[i - 1] };
            if t > max {
                max = t;
                max_c = keys_pressed.chars().nth(i).unwrap();
            } else if t == max {
                max_c = max_c.max(keys_pressed.chars().nth(i).unwrap());
            }
        }
        max_c
    }
}