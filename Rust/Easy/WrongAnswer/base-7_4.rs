impl Solution {
    pub fn convert_to_base7(num: i32) -> String {
        
        let mut n = num;
        let mut result = String::new();
        let mut is_negative = false;
        if n < 0 {
            is_negative = true;
            n = -n;
        }
        while n > 0 {
            result.push_str(&(n % 7).to_string());
            n /= 7;
        }
        if is_negative {
            result.push_str("-");
        }
        result.chars().rev().collect::<String>()
    }
}