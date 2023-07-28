impl Solution {
    pub fn find_nth_digit(n: i32) -> i32 {
        

        let mut n = n as i64;
        let mut digit = 1;
        let mut start = 1;
        let mut count = 9;
        while n > count {
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        let num = start + (n - 1) / digit;
        let idx = (n - 1) % digit;
        let mut num = num.to_string();
        num.chars().nth(idx as usize).unwrap().to_digit(10).unwrap() as i32
    }
}