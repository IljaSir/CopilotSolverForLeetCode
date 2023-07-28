impl Solution {
    pub fn add_binary(a: String, b: String) -> String {
        
        let mut a = a.as_bytes();
        let mut b = b.as_bytes();
        let mut carry = 0;
        let mut ret = vec![];
        while a.len() > 0 || b.len() > 0 || carry > 0 {
            let mut sum = carry;
            if a.len() > 0 {
                sum += a[a.len() - 1] - '0' as u8;
                a = &a[..a.len() - 1];
            }
            if b.len() > 0 {
                sum += b[b.len() - 1] - '0' as u8;
                b = &b[..b.len() - 1];
            }
            ret.push((sum % 2 + '0' as u8) as char);
            carry = sum / 2;
        }
        ret.into_iter().rev().collect()
    }
}