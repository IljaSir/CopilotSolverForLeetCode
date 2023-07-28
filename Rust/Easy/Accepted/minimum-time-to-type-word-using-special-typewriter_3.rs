impl Solution {
    pub fn min_time_to_type(word: String) -> i32 {
        
        let mut pre = 'a';
        let mut res = 0;
        for c in word.chars() {
            let mut diff = (c as i32 - pre as i32).abs();
            if diff > 13 {
                diff = 26 - diff;
            }
            res += diff;
            pre = c;
        }
        res + word.len() as i32
    }
}