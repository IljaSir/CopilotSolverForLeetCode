impl Solution {
    pub fn remove_duplicates(nums: &mut Vec<i32>) -> i32 {
        

        let mut i = 0;
        let mut count = 0;
        while i < nums.len() {
            let mut j = i + 1;
            while j < nums.len() && nums[j] == nums[i] {
                j += 1;
            }
            let k = j - i;
            if k > 2 {
                count += k - 2;
                nums[i + 2..j].rotate_left(k - 2);
            }
            i += k;
        }
        (nums.len() - count) as i32
    }
}