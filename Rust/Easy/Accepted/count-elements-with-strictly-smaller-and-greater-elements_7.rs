impl Solution {
    pub fn count_elements(nums: Vec<i32>) -> i32 {
        
        let mut cnt = 0;
        for i in 0..nums.len() {
            let mut smaller = false;
            let mut greater = false;
            for j in 0..nums.len() {
                if j == i {
                    continue;
                }
                if nums[j] < nums[i] {
                    smaller = true;
                } else if nums[j] > nums[i] {
                    greater = true;
                }
                if smaller && greater {
                    cnt += 1;
                    break;
                }
            }
        }
        cnt
    }
}