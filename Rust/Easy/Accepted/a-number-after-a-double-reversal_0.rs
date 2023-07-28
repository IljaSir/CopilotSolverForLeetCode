impl Solution {
    pub fn is_same_after_reversals(num: i32) -> bool {
        
        let reversed1 = num.to_string().chars().rev().collect::<String>().parse::<i32>().unwrap();
        let reversed2 = reversed1.to_string().chars().rev().collect::<String>().parse::<i32>().unwrap();
        reversed2 == num
    }
}