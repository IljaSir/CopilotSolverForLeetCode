impl Solution {
    pub fn smallest_number(num: i64) -> i64 {
        
        let mut num = num;
        let mut negative = false;
        if num < 0 {
            negative = true;
            num = -num;
        }
        let mut num = num.to_string();
        num.chars().collect::<Vec<char>>().sort();
        let mut num = num.parse::<i64>().unwrap();
        if negative {
            num = -num;
        }
        num
    }
}