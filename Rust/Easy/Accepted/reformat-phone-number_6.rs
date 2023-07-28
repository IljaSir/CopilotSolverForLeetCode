impl Solution {
    pub fn reformat_number(number: String) -> String {
        
        let mut res = String::new();
        let mut num = number.chars().filter(|c| c.is_digit(10)).collect::<Vec<char>>();
        while num.len() > 4 {
            res.push_str(&num[0..3].iter().collect::<String>());
            res.push('-');
            num.drain(..3);
        }
        if num.len() == 4 {
            res.push_str(&num[0..2].iter().collect::<String>());
            res.push('-');
            res.push_str(&num[2..4].iter().collect::<String>());
        } else {
            res.push_str(&num.iter().collect::<String>());
        }
        res
    }
}