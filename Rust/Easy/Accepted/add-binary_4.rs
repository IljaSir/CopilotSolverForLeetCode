impl Solution {
    pub fn add_binary(a: String, b: String) -> String {
        
        let mut a = a;
        let mut b = b;
        let mut res = String::new();
        let mut carry = false;
        while !a.is_empty() || !b.is_empty() || carry {
            let mut sum = 0;
            if let Some(c) = a.pop() {
                sum += c.to_digit(10).unwrap();
            }
            if let Some(c) = b.pop() {
                sum += c.to_digit(10).unwrap();
            }
            if carry {
                sum += 1;
            }
            carry = sum >= 2;
            res.push((sum % 2).to_string().pop().unwrap());
        }
        res.chars().rev().collect()
    }
}