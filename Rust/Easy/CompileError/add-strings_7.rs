impl Solution {
    pub fn add_strings(num1: String, num2: String) -> String {
        
        let mut num1 = num1.as_bytes();
        let mut num2 = num2.as_bytes();
        let mut carry = 0;
        let mut out = String::new();
        while !num1.is_empty() || !num2.is_empty() {
            let mut sum = carry;
            if let Some(n1) = num1.pop() {
                sum += n1 - b'0';
            }
            if let Some(n2) = num2.pop() {
                sum += n2 - b'0';
            }
            out.push((sum % 10 + b'0') as char);
            carry = sum / 10;
        }
        if carry > 0 {
            out.push((carry + b'0') as char);
        }
        out.chars().rev().collect()
    }
}