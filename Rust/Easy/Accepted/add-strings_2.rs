impl Solution {
    pub fn add_strings(num1: String, num2: String) -> String {
        
        let mut num1 = num1;
        let mut num2 = num2;
        let mut result = String::new();
        let mut carry = 0;
        while num1.len() > 0 || num2.len() > 0 {
            let mut sum = carry;
            if num1.len() > 0 {
                sum += num1.pop().unwrap() as i32 - '0' as i32;
            }
            if num2.len() > 0 {
                sum += num2.pop().unwrap() as i32 - '0' as i32;
            }
            result.push((sum % 10 + '0' as i32) as u8 as char);
            carry = sum / 10;
        }
        if carry > 0 {
            result.push((carry + '0' as i32) as u8 as char);
        }
        result.chars().rev().collect()
    }
}