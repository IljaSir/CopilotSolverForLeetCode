impl Solution {
    pub fn slowest_key(release_times: Vec<i32>, keys_pressed: String) -> char {
        
        let mut max = release_times[0];
        let mut max_char = keys_pressed.chars().next().unwrap();
        for i in 1..release_times.len() {
            let time = release_times[i] - release_times[i - 1];
            if time > max {
                max = time;
                max_char = keys_pressed.chars().nth(i).unwrap();
            } else if time == max && keys_pressed.chars().nth(i).unwrap() > max_char {
                max_char = keys_pressed.chars().nth(i).unwrap();
            }
        }
        max_char
    }
}