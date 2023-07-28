impl Solution {
    pub fn digit_count(num: String) -> bool {
        
        let mut counts = vec![0; 10];
        for c in num.chars() {
            counts[c as usize - '0' as usize] += 1;
        }
        for (i, c) in num.chars().enumerate() {
            if counts[c as usize - '0' as usize] != i + 1 {
                return false;
            }
        }
        true
    }
}