impl Solution {
    pub fn sort_colors(nums: &mut Vec<i32>) {
        

        let mut i = 0;
        let mut j = 0;
        let mut k = nums.len() - 1;
        while j <= k {
            if nums[j] == 0 {
                nums.swap(i, j);
                j += 1;
                i += 1;
            } else if nums[j] == 2 {
                nums.swap(j, k);
                k -= 1;
            } else {
                j += 1;
            }
        }
    }
}