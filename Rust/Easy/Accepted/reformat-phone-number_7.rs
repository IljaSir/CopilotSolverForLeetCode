impl Solution {
    pub fn reformat_number(number: String) -> String {
        
        let mut number = number.chars().filter(|c| c.is_digit(10)).collect::<Vec<_>>();
        let mut res = String::new();
        while number.len() > 4 {
            res += &number.drain(..3).collect::<String>();
            res += "-";
        }
        match number.len() {
            4 => {
                res += &number.drain(..2).collect::<String>();
                res += "-";
                res += &number.drain(..2).collect::<String>();
            }
            _ => {
                res += &number.drain(..).collect::<String>();
            }
        }
        res
    }
}