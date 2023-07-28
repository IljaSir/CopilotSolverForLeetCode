impl Solution {
    pub fn digit_count(num: String) -> bool {
        
        let mut digits: Vec<i32> = vec![0; 10];
        for c in num.chars() {
            digits[c.to_digit(10).unwrap() as usize] += 1;
        }
        for i in 0..10 {
            if digits[i] != 0 && digits[i] != i as i32 {
                return false;
            }
        }
        true
    }
}