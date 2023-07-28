impl Solution {
    pub fn find_nth_digit(n: i32) -> i32 {
        

        let mut n = n as usize;
        let mut base = 9;
        let mut digits = 1;
        while n > base * digits {
            n -= base * digits;
            base *= 10;
            digits += 1;
        }
        let num = base / 9 + (n - 1) / digits;
        let idx = (n - 1) % digits;
        let mut num = num.to_string();
        num.chars().nth(idx).unwrap().to_digit(10).unwrap() as i32
    }
}