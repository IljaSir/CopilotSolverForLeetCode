impl Solution {
    pub fn min_time_to_type(word: String) -> i32 {
        
        let mut ans = 0;
        let mut last = 'a';
        for c in word.chars() {
            ans += 1;
            let mut a = (c as i32 - last as i32).abs();
            if a > 13 {
                a = 26 - a;
            }
            ans += a;
            last = c;
        }
        ans
    }
}