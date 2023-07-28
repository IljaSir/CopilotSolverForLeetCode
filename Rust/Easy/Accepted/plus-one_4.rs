impl Solution {
    pub fn plus_one(digits: Vec<i32>) -> Vec<i32> {
        
        let mut digits = digits;
        let mut carry = 1;
        for i in (0..digits.len()).rev() {
            let sum = digits[i] + carry;
            if sum > 9 {
                digits[i] = sum - 10;
                carry = 1;
            } else {
                digits[i] = sum;
                carry = 0;
            }
        }
        if carry == 1 {
            digits.insert(0, 1);
        }
        digits
    }
}