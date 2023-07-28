impl Solution {
    pub fn largest_palindromic(num: String) -> String {
        
        let mut num = num;
        num.sort_unstable();
        let mut result = String::new();
        let mut carry = 0;
        for i in (0..num.len()).rev() {
            let digit = num.chars().nth(i).unwrap().to_digit(10).unwrap();
            let sum = digit + carry;
            if sum % 2 == 0 {
                result.push_str(&((sum / 2).to_string()));
            } else {
                result.push_str(&(((sum - 1) / 2).to_string()));
                carry = 1;
            }
        }
        if carry == 1 {
            result.push('1');
        }
        result
    }
}