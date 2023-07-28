impl Solution {
    pub fn three_sum_closest(nums: Vec<i32>, target: i32) -> i32 {
        

        let mut nums = nums;
        nums.sort();
        let mut ans = nums[0] + nums[1] + nums[2];
        for i in 0..nums.len() {
            let mut j = i + 1;
            let mut k = nums.len() - 1;
            while j < k {
                let sum = nums[i] + nums[j] + nums[k];
                if (target - sum).abs() < (target - ans).abs() {
                    ans = sum;
                }
                if sum < target {
                    j += 1;
                } else if sum > target {
                    k -= 1;
                } else {
                    return ans;
                }
            }
        }
        ans
    }
}