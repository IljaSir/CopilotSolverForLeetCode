impl Solution {
    pub fn plus_one(digits: Vec<i32>) -> Vec<i32> {
        
        let mut res = Vec::new();
        let mut carry = 1;
        for i in (0..digits.len()).rev() {
            let sum = digits[i] + carry;
            carry = sum / 10;
            res.push(sum % 10);
        }
        if carry > 0 {
            res.push(carry);
        }
        res.reverse();
        res
    }
}