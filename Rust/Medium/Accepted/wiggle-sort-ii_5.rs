impl Solution {
    pub fn wiggle_sort(nums: &mut Vec<i32>) {
        

        nums.sort();
        let mut tmp = nums.clone();
        let mut i = 0;
        let mut j = (nums.len() + 1) / 2 - 1;
        let mut k = nums.len() - 1;
        while i < nums.len() {
            if i % 2 == 0 {
                nums[i] = tmp[j];
                j -= 1;
            } else {
                nums[i] = tmp[k];
                k -= 1;
            }
            i += 1;
        }
    }
}