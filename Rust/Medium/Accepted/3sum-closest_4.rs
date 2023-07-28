impl Solution {
    pub fn three_sum_closest(nums: Vec<i32>, target: i32) -> i32 {
        

        let mut nums = nums;
        nums.sort();
        let mut ans = nums[0] + nums[1] + nums[2];
        for i in 0..nums.len() {
            let mut start = i + 1;
            let mut end = nums.len() - 1;
            while start < end {
                let sum = nums[i] + nums[start] + nums[end];
                if sum > target {
                    end -= 1;
                } else {
                    start += 1;
                }
                if (target - sum).abs() < (target - ans).abs() {
                    ans = sum;
                }
            }
        }
        ans
    }
}