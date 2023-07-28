impl Solution {
    pub fn sorted_squares(nums: Vec<i32>) -> Vec<i32> {
        
        nums.into_iter().map(|x| x.pow(2)).collect::<Vec<i32>>().into_iter().sorted().collect()
    }
}