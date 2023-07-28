impl Solution {
    pub fn add_binary(a: String, b: String) -> String {
        
        let mut a = a.as_bytes().to_vec();
        let mut b = b.as_bytes().to_vec();
        let mut res = Vec::new();
        let mut carry = 0;
        loop {
            if a.is_empty() && b.is_empty() {
                break;
            }
            let mut sum = carry;
            if !a.is_empty() {
                sum += a.pop().unwrap() - b'0';
            }
            if !b.is_empty() {
                sum += b.pop().unwrap() - b'0';
            }
            carry = sum / 2;
            res.push((sum % 2 + b'0') as char);
        }
        if carry > 0 {
            res.push('1');
        }
        res.into_iter().rev().collect()
    }
}