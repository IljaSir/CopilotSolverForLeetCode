impl Solution {
    pub fn subsets_with_dup(nums: Vec<i32>) -> Vec<Vec<i32>> {
        

        let mut res = vec![vec![]];
        let mut nums = nums;
        nums.sort();
        for i in 0..nums.len() {
            let mut tmp = vec![];
            if i > 0 && nums[i] == nums[i - 1] {
                tmp = res[res.len() - (1 << (i - 1))..].to_vec();
            } else {
                for j in 0..res.len() {
                    tmp.push(res[j].to_vec());
                }
            }
            for j in 0..tmp.len() {
                tmp[j].push(nums[i]);
            }
            res.append(&mut tmp);
        }
        res
    }
}