impl Solution {
    pub fn largest_palindrome(n: i32) -> i32 {
        
        if n == 1 {
            return 9;
        }
        let upper = 10_i64.pow(n as u32) - 1;
        let lower = 10_i64.pow(n as u32 - 1);
        let mut max = 0;
        for i in (lower..=upper).rev() {
            let mut left = i;
            let mut right = 0;
            while left > 0 {
                right = right * 10 + left % 10;
                left /= 10;
            }
            let mut j = upper;
            while j * j > max {
                let product = i * j;
                if product > max && product == (product / 10) * 10 + right {
                    max = product;
                }
                j -= 1;
            }
        }
        (max % 1337) as i32
    }
}