impl Solution {
    pub fn triangle_number(nums: Vec<i32>) -> i32 {
        

        let mut nums = nums;
        nums.sort();
        let mut count = 0;
        for i in (2..nums.len()).rev() {
            let mut l = 0;
            let mut r = i - 1;
            while l < r {
                if nums[l] + nums[r] > nums[i] {
                    count += r - l;
                    r -= 1;
                } else {
                    l += 1;
                }
            }
        }
        count
    }
}