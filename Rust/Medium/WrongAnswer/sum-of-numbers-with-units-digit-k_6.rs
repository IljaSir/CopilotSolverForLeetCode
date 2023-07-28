impl Solution {
    pub fn minimum_numbers(num: i32, k: i32) -> i32 {
        
        let mut res = 0;
        let mut n = num;
        while n > 0 {
            let d = (n % 10).min(k);
            res += 1;
            n -= d;
            n /= 10;
        }
        res
    }
}