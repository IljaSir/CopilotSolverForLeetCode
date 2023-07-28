impl Solution {
    pub fn add_strings(num1: String, num2: String) -> String {
        
        let mut i = num1.len() - 1;
        let mut j = num2.len() - 1;
        let mut carry = 0;
        let mut res = String::new();
        while i < num1.len() || j < num2.len() || carry > 0 {
            let mut sum = carry;
            if i < num1.len() {
                sum += (num1.as_bytes()[i] - b'0') as i32;
                i -= 1;
            }
            if j < num2.len() {
                sum += (num2.as_bytes()[j] - b'0') as i32;
                j -= 1;
            }
            carry = sum / 10;
            res.push((sum % 10 + b'0') as char);
        }
        res.chars().rev().collect()
    }
}