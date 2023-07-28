impl Solution {
    pub fn digit_count(num: String) -> bool {
        
        let mut count = vec![0; 10];
        for c in num.chars() {
            count[c as usize - '0' as usize] += 1;
        }
        for (i, c) in num.chars().enumerate() {
            if count[c as usize - '0' as usize] != i + 1 {
                return false;
            }
        }
        true
    }
}