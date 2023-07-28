impl Solution {
    pub fn majority_element(nums: Vec<i32>) -> Vec<i32> {
        

        let mut res = Vec::new();
        let n = nums.len();
        if n == 1 {
            res.push(nums[0]);
            return res;
        }
        let mut nums = nums;
        nums.sort();
        let mut i = 0;
        while i < n {
            let mut j = i + 1;
            while j < n && nums[j] == nums[i] {
                j += 1;
            }
            if j - i > n / 3 {
                res.push(nums[i]);
            }
            i = j;
        }
        res
    }
}