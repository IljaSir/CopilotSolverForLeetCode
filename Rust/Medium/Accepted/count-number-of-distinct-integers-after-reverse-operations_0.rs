impl Solution {
    pub fn count_distinct_integers(nums: Vec<i32>) -> i32 {
        
        let mut s: std::collections::HashSet<i32> = std::collections::HashSet::new();
        for i in nums {
            s.insert(i);
            s.insert(i.to_string().chars().rev().collect::<String>().parse::<i32>().unwrap());
        }
        s.len() as i32
    }
}