impl Solution {
    pub fn count_special_numbers(n: i32) -> i32 {
        
        let mut count = 0;
        for i in 1..=n {
            let mut temp = i;
            let mut digits = vec![];
            while temp > 0 {
                let digit = temp % 10;
                temp /= 10;
                if digits.contains(&digit) {
                    break;
                } else {
                    digits.push(digit);
                }
            }
            if digits.len() == i.to_string().len() {
                count += 1;
            }
        }
        count
    }
}