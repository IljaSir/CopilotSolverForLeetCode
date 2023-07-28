impl Solution {
    pub fn add_strings(num1: String, num2: String) -> String {
        
        let mut result = String::new();
        let mut carry = 0;
        let (mut num1, mut num2) = (num1, num2);
        while num1.len() > 0 || num2.len() > 0 {
            let (mut n1, mut n2) = (0, 0);
            if num1.len() > 0 {
                n1 = num1.pop().unwrap() as i32 - '0' as i32;
            }
            if num2.len() > 0 {
                n2 = num2.pop().unwrap() as i32 - '0' as i32;
            }
            let sum = n1 + n2 + carry;
            carry = sum / 10;
            result.insert(0, (sum % 10 + '0' as i32) as u8 as char);
        }
        if carry > 0 {
            result.insert(0, (carry + '0' as i32) as u8 as char);
        }
        result
    }
}