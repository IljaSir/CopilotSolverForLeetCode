impl Solution {
    pub fn min_operations(nums: Vec<i32>, nums_divide: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        let mut nums_divide = nums_divide;
        nums.sort();
        nums_divide.sort();
        let mut ans = -1;
        for i in nums_divide[0]..=nums_divide[nums_divide.len()-1] {
            let mut cnt = 0;
            for j in 0..nums.len() {
                if nums[j] % i != 0 {
                    cnt += 1;
                }
            }
            if ans == -1 || cnt < ans {
                ans = cnt;
            }
        }
        ans
    }
}