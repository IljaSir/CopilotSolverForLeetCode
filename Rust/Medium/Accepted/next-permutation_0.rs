impl Solution {
    pub fn next_permutation(nums: &mut Vec<i32>) {
        

        let mut i = (nums.len() - 1) as i32;
        while i > 0 && nums[i as usize] <= nums[(i - 1) as usize] {
            i -= 1;
        }
        if i > 0 {
            let mut j = (nums.len() - 1) as i32;
            while nums[j as usize] <= nums[(i - 1) as usize] {
                j -= 1;
            }
            nums.swap(j as usize, (i - 1) as usize);
        }
        let mut j = (nums.len() - 1) as i32;
        while i < j {
            nums.swap(i as usize, j as usize);
            i += 1;
            j -= 1;
        }
    }
}