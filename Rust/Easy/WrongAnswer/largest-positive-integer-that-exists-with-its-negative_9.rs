impl Solution {
    pub fn find_max_k(nums: Vec<i32>) -> i32 {
        
        let mut a = nums.clone();
        a.sort();
        let mut i = a.len() - 1;
        while i > 0 {
            if a[i] + a[i - 1] == 0 {
                return a[i];
            }
            i -= 1;
        }
        -1
    }
}