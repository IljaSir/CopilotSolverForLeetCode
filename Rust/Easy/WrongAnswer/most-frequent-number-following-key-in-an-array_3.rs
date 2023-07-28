impl Solution {
    pub fn most_frequent(nums: Vec<i32>, key: i32) -> i32 {
        
        let mut target = 0;
        let mut count = 0;
        let mut temp = 0;
        for i in 0..nums.len() - 1 {
            if nums[i] == key {
                if nums[i + 1] == target {
                    temp += 1;
                } else {
                    temp = 1;
                }
                target = nums[i + 1];
                if temp > count {
                    count = temp;
                }
            }
        }
        target
    }
}