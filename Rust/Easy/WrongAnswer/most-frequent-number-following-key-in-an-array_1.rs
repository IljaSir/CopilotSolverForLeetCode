impl Solution {
    pub fn most_frequent(nums: Vec<i32>, key: i32) -> i32 {
        
        let mut ans = 0;
        let mut max = 0;
        let mut count = 0;
        for i in 0..nums.len() {
            if nums[i] == key {
                count = 0;
            } else if count == 0 {
                count = 1;
                ans = nums[i];
            } else if nums[i] == ans {
                count += 1;
            } else {
                count -= 1;
            }
            if count > max {
                max = count;
                ans = nums[i];
            }
        }
        ans
    }
}