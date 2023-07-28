impl Solution {
    pub fn abbreviate_product(left: i32, right: i32) -> String {
        
        let mut product = 1;
        let mut trailing_zeros = 0;
        for i in left..=right {
            product *= i;
            while product % 10 == 0 {
                product /= 10;
                trailing_zeros += 1;
            }
            product %= 100_000;
        }
        let mut result = product.to_string();
        if trailing_zeros > 0 {
            result += &format!("e{}", trailing_zeros);
        }
        result
    }
}