impl Solution {
    pub fn digit_count(num: String) -> bool {
        
        let mut count = vec![0;10];
        for ch in num.chars() {
            count[ch as usize - 48] += 1;
        }
        for (i, ch) in num.chars().enumerate() {
            let ch = ch as usize - 48;
            if count[ch] != ch {
                return false;
            }
        }
        true
    }
}