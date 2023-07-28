impl Solution {
    pub fn min_moves(nums: Vec<i32>) -> i32 {
        

        let min = nums.iter().min().unwrap();
        let mut moves = 0;
        for i in nums.iter() {
            moves += i - min;
        }
        moves
    }
}