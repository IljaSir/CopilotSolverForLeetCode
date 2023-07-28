impl Solution {
    pub fn add_binary(a: String, b: String) -> String {
        
        let mut ret = String::new();
        let mut carry = 0;
        let mut i = a.len() - 1;
        let mut j = b.len() - 1;
        while i < a.len() || j < b.len() || carry != 0 {
            let mut sum = carry;
            if i < a.len() {
                sum += a.chars().nth(i).unwrap() as u8 - '0' as u8;
                i -= 1;
            }
            if j < b.len() {
                sum += b.chars().nth(j).unwrap() as u8 - '0' as u8;
                j -= 1;
            }
            carry = sum / 2;
            ret.push((sum % 2 + '0' as u8) as char);
        }
        ret.chars().rev().collect()
    }
}