impl Solution {
    pub fn mask_pii(s: String) -> String {
        
        let mut chars = s.chars();
        if chars.any(|c| c.is_alphabetic()) {
            let mut name = chars.take_while(|c| *c != '@').collect::<String>();
            let domain = chars.collect::<String>();
            name = name.to_lowercase();
            name.replace_range(1..name.len() - 1, &"*".repeat(name.len() - 2));
            format!("{}@{}", name, domain.to_lowercase())
        } else {
            let mut digits = s.chars().filter(|c| c.is_digit(10)).collect::<String>();
            let mut code = digits.len() - 10;
            digits.replace_range(..code, &"+".repeat(code));
            digits.replace_range(digits.len() - 4.., "XXXX");
            digits
        }
    }
}