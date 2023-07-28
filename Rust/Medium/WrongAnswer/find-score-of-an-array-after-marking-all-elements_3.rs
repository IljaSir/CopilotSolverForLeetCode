impl Solution {
    pub fn find_score(nums: Vec<i32>) -> i64 {
        
        let mut nums = nums;
        let mut score = 0;
        let mut i = 0;
        while i < nums.len() {
            let mut min = i;
            for j in i..nums.len() {
                if nums[j] < nums[min] {
                    min = j;
                }
            }
            score += nums[min] as i64;
            nums[min] = 0;
            if min > 0 {
                nums[min - 1] = 0;
            }
            if min < nums.len() - 1 {
                nums[min + 1] = 0;
            }
            i = min + 1;
        }
        score
    }
}