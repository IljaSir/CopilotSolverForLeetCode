impl Solution {
    pub fn plus_one(digits: Vec<i32>) -> Vec<i32> {
        
        let mut digits = digits;
        let mut i = digits.len() - 1;
        loop {
            if i < 0 {
                digits.insert(0, 1);
                break;
            }
            if digits[i] != 9 {
                digits[i] += 1;
                break;
            } else {
                digits[i] = 0;
                i -= 1;
            }
        }
        digits
    }
}