impl Solution {
    pub fn add_binary(a: String, b: String) -> String {
        
        let a = a.as_bytes();
        let b = b.as_bytes();
        let mut carry = 0;
        let mut i = a.len();
        let mut j = b.len();
        let mut ans = Vec::new();
        while i > 0 || j > 0 || carry > 0 {
            let mut sum = carry;
            if i > 0 {
                i -= 1;
                sum += a[i] - b'0';
            }
            if j > 0 {
                j -= 1;
                sum += b[j] - b'0';
            }
            carry = sum / 2;
            sum %= 2;
            ans.push((sum + b'0') as char);
        }
        ans.into_iter().rev().collect()
    }
}