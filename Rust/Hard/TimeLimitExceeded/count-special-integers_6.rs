impl Solution {
    pub fn count_special_numbers(n: i32) -> i32 {
        
        let mut count = 0;
        for i in 1..=n {
            let mut m = i;
            let mut digits = vec![false; 10];
            let mut is_special = true;
            while m > 0 {
                let digit = m % 10;
                if digits[digit as usize] {
                    is_special = false;
                    break;
                }
                digits[digit as usize] = true;
                m /= 10;
            }
            if is_special {
                count += 1;
            }
        }
        count
    }
}