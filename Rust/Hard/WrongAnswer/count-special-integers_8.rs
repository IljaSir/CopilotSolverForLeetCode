impl Solution {
    pub fn count_special_numbers(n: i32) -> i32 {
        
        let mut result = 0;
        let mut i = 1;
        while i <= n {
            let mut j = i;
            let mut digits = vec![];
            while j > 0 {
                let digit = j % 10;
                j /= 10;
                if digits.contains(&digit) {
                    break;
                }
                digits.push(digit);
            }
            if j == 0 {
                result += 1;
            }
            i += 1;
        }
        result
    }
}