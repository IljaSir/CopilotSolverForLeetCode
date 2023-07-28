impl Solution {
    pub fn most_frequent(nums: Vec<i32>, key: i32) -> i32 {
        
        let mut count = 0;
        let mut max = 0;
        let mut max_num = 0;
        for i in 0..nums.len() {
            if nums[i] == key {
                for j in i + 1..nums.len() {
                    if nums[j] == key {
                        break;
                    }
                    if nums[j] != nums[i] {
                        count += 1;
                    }
                    if count > max {
                        max = count;
                        max_num = nums[j];
                    }
                }
                count = 0;
            }
        }
        return max_num;
    }
}