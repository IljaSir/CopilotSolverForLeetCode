impl Solution {
    pub fn min_time_to_type(word: String) -> i32 {
        
        let mut res = 0;
        let mut prev = 'a';
        for c in word.chars() {
            let x = (c as i32 - prev as i32).abs();
            res += 1 + x.min(26 - x);
            prev = c;
        }
        res
    }
}