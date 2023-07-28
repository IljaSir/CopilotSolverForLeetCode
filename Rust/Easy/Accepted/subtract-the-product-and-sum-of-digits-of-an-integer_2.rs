impl Solution {
    pub fn subtract_product_and_sum(n: i32) -> i32 {
        
        let mut product = 1;
        let mut sum = 0;
        let mut n = n;
        while n > 0 {
            product *= n % 10;
            sum += n % 10;
            n /= 10;
        }
        product - sum
    }
}