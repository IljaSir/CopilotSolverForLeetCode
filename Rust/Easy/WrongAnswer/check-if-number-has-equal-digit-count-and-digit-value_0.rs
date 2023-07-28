impl Solution {
    pub fn digit_count(num: String) -> bool {
        
        let mut count = vec![0; 10];
        for c in num.chars() {
            count[c as usize - '0' as usize] += 1;
        }
        for i in 0..10 {
            if count[i] > 0 && count[i] != i {
                return false;
            }
        }
        true
    }
}