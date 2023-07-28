impl Solution {
    pub fn most_frequent(nums: Vec<i32>, key: i32) -> i32 {
        
        let mut max = 0;
        let mut max_count = 0;
        let mut count = 0;
        for i in 0..nums.len() {
            if nums[i] == key {
                if count > max_count {
                    max_count = count;
                    max = nums[i - 1];
                }
                count = 0;
            } else {
                count += 1;
            }
        }
        if count > max_count {
            max = nums[nums.len() - 1];
        }
        max
    }
}