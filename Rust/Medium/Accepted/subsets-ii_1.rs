impl Solution {
    pub fn subsets_with_dup(nums: Vec<i32>) -> Vec<Vec<i32>> {
        

        let mut res = vec![vec![]];
        let mut nums = nums;
        nums.sort();
        let mut i = 0;
        while i < nums.len() {
            let mut j = i;
            while j < nums.len() && nums[j] == nums[i] {
                j += 1;
            }
            let n = res.len();
            for k in 0..n {
                let mut subset = res[k].clone();
                for _ in i..j {
                    subset.push(nums[i]);
                    res.push(subset.clone());
                }
            }
            i = j;
        }
        res
    }
}