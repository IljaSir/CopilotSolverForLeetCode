impl Solution {
    pub fn smallest_number(num: i64) -> i64 {
        
        let mut num = num.to_string();
        let mut num = num.chars().collect::<Vec<char>>();
        num.sort();
        num.iter().collect::<String>().parse::<i64>().unwrap()
    }
}