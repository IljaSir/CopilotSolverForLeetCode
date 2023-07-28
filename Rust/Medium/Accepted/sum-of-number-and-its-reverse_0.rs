impl Solution {
    pub fn sum_of_number_and_reverse(num: i32) -> bool {
        
        for i in 0..=num {
            if i + i.to_string().chars().rev().collect::<String>().parse::<i32>().unwrap() == num {
                return true;
            }
        }
        false
    }
}