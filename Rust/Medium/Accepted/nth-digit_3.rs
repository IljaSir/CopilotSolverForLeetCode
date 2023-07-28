impl Solution {
    pub fn find_nth_digit(n: i32) -> i32 {
        

        let mut n = n as usize;
        let mut digit = 1;
        let mut start = 1;
        let mut count = 9;
        while n > count {
            n -= count;
            digit += 1;
            start *= 10;
            count = 9 * start * digit;
        }
        let num = start + (n - 1) / digit;
        let mut res = num.to_string().chars().nth((n - 1) % digit).unwrap();
        res.to_digit(10).unwrap() as i32
    }
}