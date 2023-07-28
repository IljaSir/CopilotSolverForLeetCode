impl Solution {
    pub fn minimum_sum(num: i32) -> i32 {
        
        let mut num = num.to_string().chars().collect::<Vec<char>>();
        num.sort();
        let mut sum = 0;
        let mut i = 0;
        while i < 2 {
            sum += num[i].to_digit(10).unwrap() * 10 + num[i + 2].to_digit(10).unwrap();
            i += 1;
        }
        sum
    }
}