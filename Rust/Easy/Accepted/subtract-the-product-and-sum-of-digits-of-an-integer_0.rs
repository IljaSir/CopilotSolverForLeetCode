impl Solution {
    pub fn subtract_product_and_sum(n: i32) -> i32 {
        
        let mut n = n;
        let mut product = 1;
        let mut sum = 0;
        while n > 0 {
            let digit = n % 10;
            product *= digit;
            sum += digit;
            n /= 10;
        }
        product - sum
    }
}