impl Solution {
    pub fn add_strings(num1: String, num2: String) -> String {
        
        let (mut num1, mut num2) = (num1.into_bytes(), num2.into_bytes());
        let (mut i, mut j) = (num1.len() - 1, num2.len() - 1);
        let mut carry = 0;
        let mut ans = Vec::new();
        while i < num1.len() || j < num2.len() || carry > 0 {
            let mut sum = carry;
            if i < num1.len() {
                sum += num1[i] - b'0';
                i += 1;
            }
            if j < num2.len() {
                sum += num2[j] - b'0';
                j += 1;
            }
            carry = sum / 10;
            ans.push((sum % 10 + b'0') as char);
        }
        ans.into_iter().rev().collect()
    }
}