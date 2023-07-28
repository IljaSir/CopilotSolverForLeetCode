impl Solution {
    pub fn find_smallest_integer(nums: Vec<i32>, value: i32) -> i32 {
        
        let mut nums = nums;
        let mut value = value;
        let mut ans = 0;
        nums.sort();
        while value >= 0 {
            let mut i = 0;
            while i < nums.len() && nums[i] <= ans {
                i += 1;
            }
            if i == nums.len() {
                break;
            }
            nums.insert(i, ans);
            ans += 1;
            value -= nums[i] - nums[i-1];
        }
        ans + if value < 0 {1} else {0}
    }
}