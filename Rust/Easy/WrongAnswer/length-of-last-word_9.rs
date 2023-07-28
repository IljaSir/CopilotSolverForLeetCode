impl Solution {
    pub fn length_of_last_word(s: String) -> i32 {
        
        let mut l = 0;
        let mut r = 0;
        let mut last = 0;
        for c in s.chars() {
            if c == ' ' {
                last = r - l;
                l = r + 1;
            }
            r += 1;
        }
        if r > l {
            last = r - l;
        }
        last as i32
    }
}