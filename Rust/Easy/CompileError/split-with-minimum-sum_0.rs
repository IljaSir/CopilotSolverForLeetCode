impl Solution {
    pub fn split_num(num: i32) -> i32 {
        
        let mut digits = [0; 10];
        let mut num = num;
        while num > 0 {
            digits[(num % 10) as usize] += 1;
            num /= 10;
        }
        let mut sum = 0;
        let mut carry = 0;
        for i in 1..10 {
            let mut count = digits[i];
            if count > 0 {
                count += carry;
                carry = count / 2;
                sum += i * (count - carry);
            }
        }
        sum
    }
}