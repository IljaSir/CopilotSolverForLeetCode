impl Solution {
    pub fn largest_integer(num: i32) -> i32 {
        
        let mut num = num;
        let mut digits: Vec<i32> = Vec::new();
        while num > 0 {
            digits.push(num % 10);
            num /= 10;
        }
        let mut evens: Vec<i32> = Vec::new();
        let mut odds: Vec<i32> = Vec::new();
        for digit in digits {
            if digit % 2 == 0 {
                evens.push(digit);
            } else {
                odds.push(digit);
            }
        }
        evens.sort();
        odds.sort();
        let mut res = 0;
        while let Some(digit) = evens.pop() {
            res = res * 10 + digit;
        }
        while let Some(digit) = odds.pop() {
            res = res * 10 + digit;
        }
        res
    }
}