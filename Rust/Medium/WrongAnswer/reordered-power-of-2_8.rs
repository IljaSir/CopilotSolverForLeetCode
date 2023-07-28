impl Solution {
    pub fn reordered_power_of2(n: i32) -> bool {
        
        let mut digits = n.to_string().chars().collect::<Vec<char>>();
        digits.sort();
        let mut num = digits.iter().collect::<String>().parse::<i32>().unwrap();
        while num <= 1000000000 {
            if num.count_ones() == 1 {
                return true;
            }
            num *= 2;
        }
        false
    }
}