impl Solution {
    pub fn subsets_with_dup(nums: Vec<i32>) -> Vec<Vec<i32>> {
        

        let mut subsets = vec![vec![]];
        let mut nums = nums;
        nums.sort();
        let mut start = 0;
        let mut end = 0;
        for i in 0..nums.len() {
            start = 0;
            if i > 0 && nums[i] == nums[i - 1] {
                start = end + 1;
            }
            end = subsets.len() - 1;
            for j in start..=end {
                let mut set = subsets[j].clone();
                set.push(nums[i]);
                subsets.push(set);
            }
        }
        subsets
    }
}