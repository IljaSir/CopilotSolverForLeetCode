impl Solution {
    pub fn min_time_to_type(word: String) -> i32 {
        
        let mut prev = 'a';
        let mut count = 0;
        for c in word.chars() {
            let d = (c as i32 - prev as i32).abs();
            count += d.min(26 - d) + 1;
            prev = c;
        }
        count
    }
}