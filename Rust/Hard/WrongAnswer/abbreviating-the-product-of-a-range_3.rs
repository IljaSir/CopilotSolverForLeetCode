impl Solution {
    pub fn abbreviate_product(left: i32, right: i32) -> String {
        
        let mut product = 1;
        let mut trail_zero = 0;
        for i in left..=right {
            product *= i;
            while product % 10 == 0 {
                product /= 10;
                trail_zero += 1;
            }
            product %= 100_000;
        }
        if product < 10_000 {
            format!("{}e{}", product, trail_zero)
        } else {
            format!("{}...{}e{}", product / 10, product % 10, trail_zero)
        }
    }
}