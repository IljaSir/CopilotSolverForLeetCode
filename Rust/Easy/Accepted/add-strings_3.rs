impl Solution {
    pub fn add_strings(num1: String, num2: String) -> String {
        
        let mut carry = 0;
        let mut i = num1.len() - 1;
        let mut j = num2.len() - 1;
        let mut sum = String::new();
        while i < num1.len() || j < num2.len() || carry != 0 {
            let mut v1 = 0;
            let mut v2 = 0;
            if i < num1.len() {
                v1 = num1.chars().nth(i).unwrap() as i32 - '0' as i32;
                i -= 1;
            }
            if j < num2.len() {
                v2 = num2.chars().nth(j).unwrap() as i32 - '0' as i32;
                j -= 1;
            }
            let mut v = v1 + v2 + carry;
            carry = 0;
            if v > 9 {
                carry = 1;
                v -= 10;
            }
            sum.insert(0, (v as u8 + '0' as u8) as char);
        }
        sum
    }
}