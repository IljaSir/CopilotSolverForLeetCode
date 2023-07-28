impl Solution {
    pub fn smallest_number(num: i64) -> i64 {
        
        let mut num = num.to_string();
        let mut num = num.chars().collect::<Vec<char>>();
        num.sort();
        let mut num = num.iter().collect::<String>();
        num = num.trim_start_matches('0').to_string();
        if num.len() == 0 {
            num = "0".to_string();
        }
        num.parse::<i64>().unwrap()
    }
}