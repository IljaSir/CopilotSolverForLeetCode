impl Solution {
    pub fn sorted_squares(nums: Vec<i32>) -> Vec<i32> {
        
        let mut r = nums.iter().map(|x| x*x).collect::<Vec<i32>>();
        r.sort();
        r
    }
}