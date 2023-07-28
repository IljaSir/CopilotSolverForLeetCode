impl Solution {
    pub fn min_time_to_type(word: String) -> i32 {
        
        let mut res = 0;
        let mut prev = 'a';
        for c in word.chars() {
            let diff = (c as i32 - prev as i32).abs();
            res += diff.min(26 - diff) + 1;
            prev = c;
        }
        res
    }
}