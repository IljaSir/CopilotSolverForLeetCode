impl Solution {
    pub fn plus_one(digits: Vec<i32>) -> Vec<i32> {
        
        let mut digits = digits;
        let mut i = digits.len() - 1;
        let mut carry = 0;
        loop {
            let mut sum = digits[i] + 1;
            if carry == 1 {
                sum += 1;
            }
            if sum == 10 {
                digits[i] = 0;
                carry = 1;
            } else {
                digits[i] = sum;
                carry = 0;
            }
            if i == 0 {
                break;
            }
            i -= 1;
        }
        if carry == 1 {
            digits.insert(0, 1);
        }
        digits
    }
}