impl Solution {
    pub fn abbreviate_product(left: i32, right: i32) -> String {
        
        let mut product = 1;
        for i in left..=right {
            product *= i;
        }
        let mut count = 0;
        while product % 10 == 0 {
            product /= 10;
            count += 1;
        }
        let mut result = String::new();
        if product.to_string().len() > 10 {
            result.push_str(&product.to_string()[..5]);
            result.push_str("...");
            result.push_str(&product.to_string()[product.to_string().len() - 5..]);
            result.push_str("e");
            result.push_str(&count.to_string());
        } else {
            result.push_str(&product.to_string());
            result.push_str("e");
            result.push_str(&count.to_string());
        }
        result
    }
}