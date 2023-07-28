impl Solution {
    pub fn count_subarrays(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut res = 0;
        let mut counts = vec![0; nums.len()+1];
        let mut count = 0;
        for i in 0..nums.len() {
            if nums[i] < k {
                count += 1;
            }
            counts[count] += 1;
        }
        count = 0;
        for i in (0..nums.len()).rev() {
            if nums[i] > k {
                count += 1;
            }
            res += counts[count];
        }
        res
    }
}