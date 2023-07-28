impl Solution {
    pub fn rotate(nums: &mut Vec<i32>, k: i32) {
        

        let mut temp: Vec<i32> = Vec::new();
        let mut j = 0;
        for i in (0..nums.len()).rev() {
            if i < k as usize {
                temp.insert(0, nums[i]);
            } else {
                nums[i] = nums[i - k as usize];
            }
        }
        for i in (0..k as usize).rev() {
            nums[i] = temp[j];
            j += 1;
        }
    }
}