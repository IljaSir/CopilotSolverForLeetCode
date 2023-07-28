impl Solution {
    pub fn count_distinct_integers(nums: Vec<i32>) -> i32 {
        
        let mut set = std::collections::HashSet::new();
        for n in nums {
            let mut s = n.to_string();
            s.chars().rev().collect::<String>().parse::<i32>().unwrap();
            set.insert(s);
        }
        set.len() as i32
    }
}