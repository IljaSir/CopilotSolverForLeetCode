impl Solution {
    pub fn count_elements(nums: Vec<i32>) -> i32 {
        
        let mut count = 0;
        for i in 0..nums.len() {
            let mut greater = false;
            let mut smaller = false;
            for j in 0..nums.len() {
                if nums[i] < nums[j] {
                    greater = true;
                }
                if nums[i] > nums[j] {
                    smaller = true;
                }
            }
            if smaller && greater {
                count += 1;
            }
        }
        count
    }
}