impl Solution {
    pub fn min_swaps(nums: Vec<i32>) -> i32 {
        
        let n = nums.len();
        let mut ones = nums.iter().filter(|&&x| x == 1).count();
        let mut i = 0;
        let mut j = 0;
        let mut max_ones = 0;
        while j < n {
            if nums[j] == 1 {
                ones -= 1;
            }
            if j - i + 1 - ones > max_ones {
                max_ones = j - i + 1 - ones;
            }
            if j - i + 1 > ones {
                if nums[i] == 1 {
                    ones += 1;
                }
                i += 1;
            }
            j += 1;
        }
        (n - max_ones) as i32
    }
}