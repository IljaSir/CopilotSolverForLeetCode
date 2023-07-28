impl Solution {
    pub fn count_special_numbers(n: i32) -> i32 {
        
        let mut count = 0;
        let mut i = 1;
        while i <= n {
            let mut digits = vec![];
            let mut num = i;
            while num > 0 {
                digits.push(num % 10);
                num /= 10;
            }
            digits.sort();
            let mut flag = true;
            for i in 0..digits.len()-1 {
                if digits[i] == digits[i+1] {
                    flag = false;
                    break;
                }
            }
            if flag {
                count += 1;
            }
            i += 1;
        }
        count
    }
}