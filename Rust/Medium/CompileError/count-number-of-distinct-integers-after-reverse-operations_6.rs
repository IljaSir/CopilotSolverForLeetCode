impl Solution {
    pub fn count_distinct_integers(nums: Vec<i32>) -> i32 {
        
        let mut set = std::collections::HashSet::new();
        for n in nums.iter() {
            let mut s = n.to_string();
            s.reverse();
            let n = s.parse::<i32>().unwrap();
            set.insert(n);
        }
        set.len() as i32
    }
}