impl Solution {
    pub fn next_permutation(nums: &mut Vec<i32>) {
        

        let mut i = nums.len() as i32 - 2;
        while i >= 0 && nums[i as usize] >= nums[i as usize + 1] {
            i -= 1;
        }
        if i >= 0 {
            let mut j = nums.len() as i32 - 1;
            while j >= 0 && nums[i as usize] >= nums[j as usize] {
                j -= 1;
            }
            nums.swap(i as usize, j as usize);
        }
        nums[i as usize + 1..].reverse();
    }
}