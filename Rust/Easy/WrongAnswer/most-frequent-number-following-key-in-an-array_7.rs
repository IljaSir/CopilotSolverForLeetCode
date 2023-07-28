impl Solution {
    pub fn most_frequent(nums: Vec<i32>, key: i32) -> i32 {
        
        let mut count = 0;
        let mut target = 0;
        let mut temp = 0;
        for i in 0..nums.len() {
            if nums[i] == key {
                temp = 0;
                for j in i+1..nums.len() {
                    if nums[j] == target {
                        temp += 1;
                    }
                    if temp > count {
                        count = temp;
                        target = nums[j];
                    }
                }
            }
        }
        target
    }
}