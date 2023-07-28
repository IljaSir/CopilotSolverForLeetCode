impl Solution {
    pub fn is_same_after_reversals(num: i32) -> bool {
        
        let reversed1 = num.to_string().chars().rev().collect::<String>();
        let reversed2 = reversed1.to_string().chars().rev().collect::<String>();
        num == reversed2.parse::<i32>().unwrap()
    }
}