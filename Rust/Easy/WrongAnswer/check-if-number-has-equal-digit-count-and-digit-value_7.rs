impl Solution {
    pub fn digit_count(num: String) -> bool {
        
        let mut counts = [0; 10];
        for c in num.chars() {
            let i = c as usize - '0' as usize;
            counts[i] += 1;
        }
        for (i, c) in num.chars().enumerate() {
            let j = c as usize - '0' as usize;
            if counts[j] != i + 1 {
                return false;
            }
        }
        true
    }
}