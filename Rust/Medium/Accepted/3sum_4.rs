impl Solution {
    pub fn three_sum(nums: Vec<i32>) -> Vec<Vec<i32>> {
        

        let mut ans = Vec::new();
        let mut nums = nums;
        nums.sort();
        let n = nums.len();
        for i in 0..n {
            if i > 0 && nums[i] == nums[i - 1] {
                continue;
            }
            let (mut l, mut r) = (i + 1, n - 1);
            while l < r {
                let sum = nums[i] + nums[l] + nums[r];
                if sum == 0 {
                    ans.push(vec![nums[i], nums[l], nums[r]]);
                    while l < r && nums[l] == nums[l + 1] {
                        l += 1;
                    }
                    while l < r && nums[r] == nums[r - 1] {
                        r -= 1;
                    }
                    l += 1;
                    r -= 1;
                } else if sum < 0 {
                    l += 1;
                } else {
                    r -= 1;
                }
            }
        }
        ans
    }
}