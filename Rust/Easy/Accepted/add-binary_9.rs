impl Solution {
    pub fn add_binary(a: String, b: String) -> String {
        
        let (a, b) = if a.len() > b.len() { (a, b) } else { (b, a) };

        let mut a = a.bytes().rev().collect::<Vec<u8>>();
        let mut b = b.bytes().rev().collect::<Vec<u8>>();
        let mut carry = 0;
        let mut result = Vec::new();

        for i in 0..a.len() {
            let (a, b) = if i < b.len() {
                (a[i] - '0' as u8, b[i] - '0' as u8)
            } else {
                (a[i] - '0' as u8, 0)
            };
            let (a, b) = (a + carry, b);
            carry = if a + b > 1 { 1 } else { 0 };
            result.push((a + b) % 2 + '0' as u8);
        }

        if carry > 0 {
            result.push('1' as u8);
        }

        result.reverse();
        String::from_utf8(result).unwrap()
    }
}