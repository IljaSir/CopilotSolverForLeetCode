impl Solution {
    pub fn min_swaps(nums: Vec<i32>) -> i32 {
        
        let mut ones = nums.iter().filter(|&&i| i == 1).count();
        let mut i = 0;
        let mut j = 0;
        let mut ans = 0;
        while j < nums.len() {
            if nums[j] == 1 { ones -= 1; }
            if j - i + 1 > ones {
                if nums[i] == 1 { ones += 1; }
                i += 1;
            }
            ans = ans.max(j - i + 1);
            j += 1;
        }
        (ones - ans) as i32
    }
}