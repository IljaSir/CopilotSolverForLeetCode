impl Solution {
    pub fn count_elements(nums: Vec<i32>) -> i32 {
        
        let mut ans = 0;
        for i in 0..nums.len() {
            let mut smaller = false;
            let mut greater = false;
            for j in 0..nums.len() {
                if i == j {
                    continue;
                }
                if nums[i] > nums[j] {
                    smaller = true;
                } else if nums[i] < nums[j] {
                    greater = true;
                }
                if smaller && greater {
                    ans += 1;
                    break;
                }
            }
        }
        ans
    }
}