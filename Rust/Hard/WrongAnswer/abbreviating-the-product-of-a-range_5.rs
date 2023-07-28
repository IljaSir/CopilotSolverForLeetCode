impl Solution {
    pub fn abbreviate_product(left: i32, right: i32) -> String {
        
        let mut product = 1;
        for i in left..=right {
            product *= i;
        }
        let mut str = product.to_string();
        let mut zeros = 0;
        let mut i = str.len() - 1;
        while i > 0 && str.chars().nth(i).unwrap() == '0' {
            zeros += 1;
            i -= 1;
        }
        str.truncate(str.len() - zeros);
        if str.len() > 10 {
            format!("{}...{}e{}", &str[0..5], &str[str.len() - 5..], zeros)
        } else {
            format!("{}e{}", str, zeros)
        }
    }
}