impl Solution {
    pub fn count_subarrays(nums: Vec<i32>, k: i32) -> i32 {
        
        let n = nums.len();
        let mut result = 0;
        for i in 0..n {
            let mut count = 0;
            for j in i..n {
                if nums[j] < k {
                    count += 1;
                } else if nums[j] == k {
                    count += 1;
                    result += count;
                } else {
                    break;
                }
            }
        }
        result
    }
}