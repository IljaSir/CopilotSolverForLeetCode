impl Solution {
    pub fn count_distinct_integers(nums: Vec<i32>) -> i32 {
        
        let mut nums: Vec<_> = nums.into_iter().map(|x| x.to_string().chars().rev().collect::<String>().parse::<i32>().unwrap()).collect();
        nums.sort();
        nums.dedup();
        nums.len() as i32
    }
}