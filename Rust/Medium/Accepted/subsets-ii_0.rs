impl Solution {
    pub fn subsets_with_dup(nums: Vec<i32>) -> Vec<Vec<i32>> {
        

        let mut nums = nums;
        nums.sort();
        let mut ans = vec![vec![]];
        let mut i = 0;
        while i < nums.len() {
            let mut j = i;
            while j < nums.len() && nums[j] == nums[i] {
                j += 1;
            }
            let mut size = ans.len();
            for k in 0..size {
                let mut subset = ans[k].clone();
                for _ in i..j {
                    subset.push(nums[i]);
                    ans.push(subset.clone());
                }
            }
            i = j;
        }
        ans
    }
}