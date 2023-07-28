impl Solution {
    pub fn remove_duplicates(nums: &mut Vec<i32>) -> i32 {
        

        let mut i = 0;
        let mut j = 0;
        let mut count = 0;
        while j < nums.len() {
            if nums[i] == nums[j] {
                count += 1;
                j += 1;
            } else {
                if count > 2 {
                    nums[i + 2..j].iter_mut().for_each(|x| *x = 0);
                }
                i = j;
                count = 0;
            }
        }
        if count > 2 {
            nums[i + 2..j].iter_mut().for_each(|x| *x = 0);
        }
        nums.iter().position(|x| *x == 0).unwrap_or(nums.len()) as i32
    }
}