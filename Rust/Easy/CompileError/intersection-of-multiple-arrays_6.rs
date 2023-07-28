impl Solution {
    pub fn intersection(nums: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut res = vec![];
        let mut set = nums[0].iter().cloned().collect::<HashSet<i32>>();
        for i in 1..nums.len() {
            set = set.intersection(&nums[i].iter().cloned().collect::<HashSet<i32>>()).cloned().collect::<HashSet<i32>>();
        }
        for i in set {
            res.push(i);
        }
        res
    }
}