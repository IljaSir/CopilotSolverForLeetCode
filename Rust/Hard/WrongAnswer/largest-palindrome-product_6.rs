impl Solution {
    pub fn largest_palindrome(n: i32) -> i32 {
        
        if n == 1 { return 9 }
        let max = 10i32.pow(n as u32) - 1;
        let min = 10i32.pow((n - 1) as u32);
        let mut res = 0;
        for i in (min..=max).rev() {
            let mut cur = i;
            let mut temp = i;
            while temp > 0 {
                cur = cur * 10 + temp % 10;
                temp /= 10;
            }
            for j in (min..=max).rev() {
                if cur / j > max { break }
                if cur % j == 0 {
                    res = cur % 1337;
                    break;
                }
            }
            if res > 0 { break }
        }
        res
    }
}