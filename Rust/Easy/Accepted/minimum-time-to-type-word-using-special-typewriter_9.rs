impl Solution {
    pub fn min_time_to_type(word: String) -> i32 {
        
        let mut res = 0;
        let mut pos = 'a' as i32;
        for c in word.chars() {
            let cur = c as i32;
            let mut diff = (pos - cur).abs();
            if diff > 13 {
                diff = 26 - diff;
            }
            res += diff + 1;
            pos = cur;
        }
        res
    }
}