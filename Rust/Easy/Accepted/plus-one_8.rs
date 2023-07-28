impl Solution {
    pub fn plus_one(digits: Vec<i32>) -> Vec<i32> {
        
        let mut carry = 1;
        let mut result = Vec::new();
        for i in (0..digits.len()).rev() {
            let mut val = digits[i] + carry;
            carry = val / 10;
            val = val % 10;
            result.push(val);
        }
        if carry > 0 {
            result.push(carry);
        }
        result.reverse();
        result
    }
}