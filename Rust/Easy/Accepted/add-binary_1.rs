impl Solution {
    pub fn add_binary(a: String, b: String) -> String {
        
        let a = a.as_bytes();
        let b = b.as_bytes();
        let mut i = a.len() - 1;
        let mut j = b.len() - 1;
        let mut carry = 0;
        let mut res = Vec::new();
        while i < a.len() || j < b.len() || carry > 0 {
            let mut sum = carry;
            if i < a.len() {
                sum += a[i] - b'0';
                i -= 1;
            }
            if j < b.len() {
                sum += b[j] - b'0';
                j -= 1;
            }
            res.push((sum % 2 + b'0') as char);
            carry = sum / 2;
        }
        res.reverse();
        res.into_iter().collect()
    }
}