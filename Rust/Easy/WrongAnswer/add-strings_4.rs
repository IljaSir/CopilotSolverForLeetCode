impl Solution {
    pub fn add_strings(num1: String, num2: String) -> String {
        
        let mut n1 = num1.chars().rev().collect::<Vec<char>>();
        let mut n2 = num2.chars().rev().collect::<Vec<char>>();
        let mut ret = String::new();
        let mut carry = 0;
        while !n1.is_empty() || !n2.is_empty() {
            let mut sum = carry;
            if !n1.is_empty() {
                sum += n1.pop().unwrap() as i32 - '0' as i32;
            }
            if !n2.is_empty() {
                sum += n2.pop().unwrap() as i32 - '0' as i32;
            }
            ret.push((sum % 10 + '0' as i32) as u8 as char);
            carry = sum / 10;
        }
        if carry > 0 {
            ret.push(carry as u8 as char);
        }
        ret.chars().rev().collect()
    }
}