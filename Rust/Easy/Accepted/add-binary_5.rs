impl Solution {
    pub fn add_binary(a: String, b: String) -> String {
        
        let mut a = a.chars().collect::<Vec<char>>();
        let mut b = b.chars().collect::<Vec<char>>();
        let mut res = vec![];
        let mut carry = 0;
        while !a.is_empty() || !b.is_empty() || carry != 0 {
            let mut sum = carry;
            if let Some(x) = a.pop() {
                sum += x as u8 - '0' as u8;
            }
            if let Some(x) = b.pop() {
                sum += x as u8 - '0' as u8;
            }
            res.push((sum % 2 + '0' as u8) as char);
            carry = sum / 2;
        }
        res.reverse();
        res.into_iter().collect()
    }
}