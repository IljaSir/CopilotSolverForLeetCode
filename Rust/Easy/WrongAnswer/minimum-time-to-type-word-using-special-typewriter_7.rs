impl Solution {
    pub fn min_time_to_type(word: String) -> i32 {
        
        let mut seconds = 0;
        let mut pointer = 'a';
        for c in word.chars() {
            let mut diff = (pointer as u8 - c as u8) as i32;
            if diff < 0 {
                diff = -diff;
            }
            if diff > 13 {
                diff = 26 - diff;
            }
            seconds += diff + 1;
            pointer = c;
        }
        seconds
    }
}