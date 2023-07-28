impl Solution {
    pub fn largest_integer(num: i32) -> i32 {
        
        let mut num = num;
        let mut odd = Vec::new();
        let mut even = Vec::new();
        while num > 0 {
            let digit = num % 10;
            if digit % 2 == 0 {
                even.push(digit);
            } else {
                odd.push(digit);
            }
            num /= 10;
        }
        even.sort();
        odd.sort();
        let mut result = 0;
        while even.len() > 0 || odd.len() > 0 {
            if let Some(&digit) = even.last() {
                result = result * 10 + digit;
                even.pop();
            }
            if let Some(&digit) = odd.last() {
                result = result * 10 + digit;
                odd.pop();
            }
        }
        result
    }
}