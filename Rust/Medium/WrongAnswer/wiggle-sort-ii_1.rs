impl Solution {
    pub fn wiggle_sort(nums: &mut Vec<i32>) {
        

        nums.sort();
        let mut i = 1;
        while i < nums.len() - 1 {
            nums.swap(i, i + 1);
            i += 2;
        }
    }
}