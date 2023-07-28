impl Solution {
    pub fn min_time_to_type(word: String) -> i32 {
        
        let mut ret = 0;
        let mut cur = 'a';
        for c in word.chars() {
            let diff = (c as i32 - cur as i32).abs();
            ret += 1 + diff.min(26 - diff);
            cur = c;
        }
        ret
    }
}