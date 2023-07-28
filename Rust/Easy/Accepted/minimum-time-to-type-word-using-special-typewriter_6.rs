impl Solution {
    pub fn min_time_to_type(word: String) -> i32 {
        
        let mut ans = 0;
        let mut pos = 0;
        for c in word.chars() {
            let c = c as i32 - 'a' as i32;
            ans += (pos - c).abs().min(26 - (pos - c).abs());
            ans += 1;
            pos = c;
        }
        ans
    }
}