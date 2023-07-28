impl Solution {
    pub fn min_increment_for_unique(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut last = -1;
        let mut res = 0;
        for num in nums {
            if num <= last {
                last += 1;
                res += last - num;
            } else {
                last = num;
            }
        }
        res
    }
}