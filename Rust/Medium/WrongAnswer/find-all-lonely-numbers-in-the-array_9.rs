impl Solution {
    pub fn find_lonely(nums: Vec<i32>) -> Vec<i32> {
        
        let mut res: Vec<i32> = Vec::new();
        let mut set: std::collections::HashSet<i32> = std::collections::HashSet::new();
        for i in nums {
            if set.contains(&(i + 1)) || set.contains(&(i - 1)) {
                set.remove(&i);
            } else {
                set.insert(i);
            }
        }
        for i in set {
            res.push(i);
        }
        res
    }
}