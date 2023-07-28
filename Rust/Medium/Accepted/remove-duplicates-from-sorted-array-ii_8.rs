impl Solution {
    pub fn remove_duplicates(nums: &mut Vec<i32>) -> i32 {
        

        let mut count = 0;
        let mut last = 0;
        let mut last_count = 0;
        for i in 0..nums.len() {
            if i == 0 {
                last = nums[i];
                last_count = 1;
            } else {
                if nums[i] == last {
                    last_count += 1;
                } else {
                    last = nums[i];
                    last_count = 1;
                }
            }
            if last_count <= 2 {
                nums[count] = nums[i];
                count += 1;
            }
        }
        count as i32
    }
}