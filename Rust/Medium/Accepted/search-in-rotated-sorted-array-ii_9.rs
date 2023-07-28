impl Solution {
    pub fn search(nums: Vec<i32>, target: i32) -> bool {
        

        nums.iter().any(|&x| x == target)
    }
}