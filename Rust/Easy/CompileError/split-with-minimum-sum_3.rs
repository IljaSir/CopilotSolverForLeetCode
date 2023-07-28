impl Solution {
    pub fn split_num(num: i32) -> i32 {
        
        let mut num = num;
        let mut digits = vec![0; 10];
        while num > 0 {
            digits[num % 10] += 1;
            num /= 10;
        }
        let mut sum = 0;
        let mut carry = 0;
        let mut i = 1;
        while i < 10 {
            if digits[i] > 0 {
                digits[i] -= 1;
                sum += i;
                break;
            }
            i += 1;
        }
        while i < 10 {
            if digits[i] > 0 {
                digits[i] -= 1;
                sum += i * 10;
                carry = 1;
                break;
            }
            i += 1;
        }
        for i in 0..10 {
            let mut j = 0;
            while j < digits[i] {
                if carry == 1 {
                    carry = 0;
                    sum += i * 100;
                } else {
                    sum += i * 10;
                }
                j += 1;
            }
        }
        sum
    }
}